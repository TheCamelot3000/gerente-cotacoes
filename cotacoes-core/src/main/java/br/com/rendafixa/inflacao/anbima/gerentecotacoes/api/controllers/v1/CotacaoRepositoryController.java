package br.com.rendafixa.inflacao.anbima.gerentecotacoes.api.controllers.v1;

import br.com.rendafixa.inflacao.anbima.gerentecotacoes.business.models.Cotacao;
import br.com.rendafixa.inflacao.anbima.gerentecotacoes.business.services.CotacaoRepositoryService;
import br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database.ResourceNotFoundException;
import br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database.SaveDataBaseException;
import br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database.UpdateDatabaseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CotacaoRepositoryController {

    @Autowired
    private CotacaoRepositoryService service;

    @PostMapping("/cotacao/save")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<Cotacao> save(@Valid @RequestBody Cotacao cotacao) throws SaveDataBaseException, JsonProcessingException {
        return new ResponseEntity<>(this.service.save(cotacao).get(), HttpStatus.OK);
    }

    @GetMapping("/cotacao/find/{id}")
    public ResponseEntity<Cotacao> findById(@RequestParam Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.service.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/cotacao/list")
    public ResponseEntity<List<Cotacao>> list() throws ResourceNotFoundException {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/cotacao/update")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<Cotacao> update(@Valid @RequestBody Cotacao cotacao) throws JsonProcessingException,ResourceNotFoundException, UpdateDatabaseException {
        return new ResponseEntity<>(this.service.update(cotacao).get(), HttpStatus.OK);
    }

    @DeleteMapping("/cotacao/delete/{id}")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<Cotacao> delete(@RequestParam Long id) throws ResourceNotFoundException, JsonProcessingException {
        return new ResponseEntity<>(this.service.delete(id).get(), HttpStatus.OK);
    }
}