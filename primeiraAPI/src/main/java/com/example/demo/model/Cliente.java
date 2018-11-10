package com.example.demo.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class Cliente {

    private Long id;
    private String nome;
    private Collection<Telefone> telefone;
    @Column(unique=true)
    private String email;
    private String senha;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="cliente")
    public Collection<Telefone> getListaTelefone() {
        return telefone;
    }

    public void setListaTelefone(Collection<Telefone> telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }
}
