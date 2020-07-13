package br.com.api.locadora.models;

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
@Table(name="FILME", schema = "public")
public class Filme implements Serializable {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(name = "NOME", nullable = false, unique = true, length = 100)
    private String nome;
    
    @Column(name = "DATA_LANC", nullable = false)
    @Temporal(TemporalType.DATE)    
    private Date dataLancamento;
    
    @Column(name = "SINOPESE", nullable = false, length = 20)
    private String sinopse;
    
    @Column(name = "IMAGEM", nullable = false, length = 200)
    private String imagem;
    
    @Column(name = "ID_AUTOR", nullable = false)
    @JoinColumn(name = "ID_AUTOR", insertable = false, updatable = false, referencedColumnName = "ID")
    private Autor autor;
    
    @Column(name = "ID_GENERO", nullable = false)
    @JoinColumn(name = "ID_GENERO", insertable = false, updatable = false, referencedColumnName = "ID")
    private Genero genero;

    public Filme() {
    }

    public Filme(UUID id, String nome, Date dataLancamento, String sinopse, String imagem, Autor autor, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.sinopse = sinopse;
        this.imagem = imagem;
        this.autor = autor;
        this.genero = genero;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}