package br.com.rendafixa.inflacao.anbima.gerentecotacoes.business.models;


import br.com.rendafixa.inflacao.anbima.gerentecotacoes.json.ObjectToJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "cotacao")
@SQLDelete(sql = "UPDATE cotacao SET is_inativo = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Cotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "Indice")
    @Enumerated(EnumType.STRING)
    private Indice indice;
    @Column(name = "Data_Coleta")
    private LocalDate dataColeta;
    @Column(name = "Mes_Referencia")
    private String mesReferencia;
    @Column(name = "Valor_Cotacao")
    private BigDecimal valor;
    @Column(name = "Data_Validade")
    private LocalDate dataValidade;
    @Column(name = "isInativo")
    private Boolean isInativo = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Indice getIndice() {
        return indice;
    }

    public void setIndice(Indice indice) {
        this.indice = indice;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Boolean getInativo() {
        return isInativo;
    }

    public void setInativo(Boolean isInativo) {
        this.isInativo = isInativo;
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectToJson().convert(this);
    }
}
