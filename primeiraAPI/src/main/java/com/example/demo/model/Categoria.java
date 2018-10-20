
package com.example.demo.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
class Categoria {
    private long id;
    private String nome;
    private Collection<Produto> produtos;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="produtos")
    public Collection<Produto> getProdutos() {
        return produtos;
    }


    public void setProdutos(Collection<Produto> produtos) {
        this.produtos = produtos;
    }
    
}
