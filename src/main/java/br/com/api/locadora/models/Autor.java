package br.com.api.locadora.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AUTOR", schema = "public")
public class Autor implements Serializable {
    
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private UUID id;
    
    @Column(name = "NOME", nullable = false, unique = true, length = 100)
    private String nome;
    
    @Column(name = "DATA_NASC", nullable = false)
    @Temporal(TemporalType.DATE)    
    private Date dataNascimento;
    
    @Column(name = "NACIONALIDADE", nullable = false, length = 20)
    private String nacionalidade;
    
    @Column(name = "IMAGEM", nullable = false, length = 200)
    private String imagem;
    
    @Column(name = "OBSERVACAO", nullable = false, length = 500)
    private String observacao;
    
    public Autor() {
    }

    public Autor(UUID id, String nome, Date dataNascimento, String nacionalidade, String imagem, String observacao) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.imagem = imagem;
        this.observacao = observacao;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
