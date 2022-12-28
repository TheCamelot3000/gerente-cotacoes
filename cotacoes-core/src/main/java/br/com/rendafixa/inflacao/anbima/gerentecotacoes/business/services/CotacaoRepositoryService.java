package br.com.rendafixa.inflacao.anbima.gerentecotacoes.business.services;

import br.com.rendafixa.inflacao.anbima.gerentecotacoes.business.models.Cotacao;
import br.com.rendafixa.inflacao.anbima.gerentecotacoes.business.repository.CotacaoRepository;
import br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database.DeleteDatabaseException;
import br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database.ResourceNotFoundException;
import br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database.SaveDataBaseException;
import br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database.UpdateDatabaseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotacaoRepositoryService {
    @Autowired
    private CotacaoRepository repository;
    private final Logger logger = LoggerFactory.getLogger(CotacaoRepositoryService.class);

    public Optional<Cotacao> save(Cotacao cotacao) throws SaveDataBaseException, JsonProcessingException {
        try {
            logger.info("Saving: " + cotacao.toJson());
            return Optional.of(this.repository.save(cotacao));
        } catch (Exception e) {
            throw new SaveDataBaseException("The resource" + cotacao.toJson() + "can't be saved");
        }
    }

    public Optional<Cotacao> update(Cotacao cotacao) throws JsonProcessingException, UpdateDatabaseException, ResourceNotFoundException {
        Optional<Cotacao> cotacaoOptional = this.findById(cotacao.getId());

        if (cotacaoOptional.isEmpty())
            throw new ResourceNotFoundException("Not found any item for update with ID" + cotacao.getId());

        logger.info("Updating resource" + cotacaoOptional.get().toJson() + " to " + cotacao.toJson());

        try {
            return Optional.of(this.repository.save(cotacao));
        } catch (Exception e) {
            throw new UpdateDatabaseException("The resource " + cotacao.toJson() + " can't be updated" + "-\n" + e.getMessage());
        }

    }

    public Optional<Cotacao> delete(Long id) throws ResourceNotFoundException, JsonProcessingException {
        Optional<Cotacao> cotacaoOptional = this.findById(id);

        if (cotacaoOptional.isEmpty())
            throw new ResourceNotFoundException("Not found any item for update with ID " + id);

        logger.info("Deleting resource " + cotacaoOptional.get().toJson());

        try {
            this.repository.deleteById(id);
            return Optional.of(cotacaoOptional.get());
        } catch (Exception e) {
            throw new DeleteDatabaseException("The resource " + cotacaoOptional.get().toJson() + " can't be deleted " + "-\n" + e.getMessage());
        }
    }

    public Optional<Cotacao> findById(Long id) throws ResourceNotFoundException {
        try {
            logger.info("Finding item with Id: " + id);
            return this.repository.findById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found item with ID:" + id);
        }
    }

    public List<Cotacao> findAll() throws ResourceNotFoundException {
        try {
            logger.info("finding All... \n");
            List<Cotacao> cotacoes = this.repository.findAll();
            logger.info("finded " + cotacoes.size() + "items");
            return cotacoes;
        } catch (Exception e) {
            throw new ResourceNotFoundException("Erro when I tryed to find all");
        }
    }
}
