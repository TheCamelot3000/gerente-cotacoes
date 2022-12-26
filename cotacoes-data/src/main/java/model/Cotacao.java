package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import json.ObjectToJson;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Cotacao")
public class Cotacao {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;
    @Column(name = "Indice")
    @NotBlank
    private Indice indice;
    @Column(name = "Data_Coelta")
    @NotBlank
    private LocalDate dataColeta;
    @Column(name = "Mes_Referencia")
    @NotBlank
    private String mesReferencia;
    @Column(name = "Valor_Cotacao")
    @NotBlank
    private BigDecimal valor;
    @Column(name = "Data_Validade")
    @NotBlank
    private LocalDate dataValidade;

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

    @Override
    public String toString() {
        return "Cotacao{" +
                "id=" + id +
                ", indice=" + indice +
                ", dataColeta=" + dataColeta +
                ", mesReferencia='" + mesReferencia + '\'' +
                ", valor=" + valor +
                ", dataValidade=" + dataValidade +
                '}';
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectToJson().convert(this);
    }
}
