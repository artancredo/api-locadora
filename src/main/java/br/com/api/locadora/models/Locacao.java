package br.com.api.locadora.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="LOCACAO", schema = "public")
public class Locacao implements Serializable {
    
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "ID_CLIENTE", nullable = false)
    @JoinColumn(name = "ID_CLIENTE", insertable = false, updatable = false, referencedColumnName = "ID")
    private Cliente cliente;
    
    @Column(name = "ID_FILME", nullable = false)
    @JoinColumn(name = "ID_FILME", insertable = false, updatable = false, referencedColumnName = "ID")
    private Filme filme;
    
    @Column(name = "DATA_INI", nullable = false)
    @Temporal(TemporalType.DATE)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "UTC")
    private Date dataInicio;
    
    @Column(name = "DATA_FIM", nullable = false)
    @Temporal(TemporalType.DATE)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "UTC")
    private Date dataFim;
    
    @Column(name = "VALOR", nullable = false)
    private Float valor;

    public Locacao() {
    }

    public Locacao(UUID id, Cliente cliente, Filme filme, Date dataInicio, Date dataFim, Float valor) {
        this.id = id;
        this.cliente = cliente;
        this.filme = filme;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
