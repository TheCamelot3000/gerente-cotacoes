package br.com.rendafixa.inflacao.anbima.gerentecotacoes.business.repository;

import br.com.rendafixa.inflacao.anbima.gerentecotacoes.business.models.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao,Long> {

}
