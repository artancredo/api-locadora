package br.com.api.locadora.models;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GENERO", schema = "public")
public class Genero implements Serializable {
    
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private UUID id;
    
    @Column(name = "DESCRICAO", nullable = false, unique = true, length = 100)
    private String descricao;

    public Genero() {
    }

    public Genero(UUID id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
