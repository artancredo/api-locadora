package br.com.api.locadora.models;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE", schema = "public")
public class Cliente implements Serializable {
    
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private UUID id;
    
    @Column(name = "NOME", nullable = false, unique = true, length = 100)
    private String nome;
    
    @Column(name = "CPF", nullable = false, unique = true, length = 11)
    private String cpf;
    
    @Column(name = "IDADE", nullable = false)
    private Integer idade;

    public Cliente() {
    }

    public Cliente(UUID id, String nome, String cpf, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
}
