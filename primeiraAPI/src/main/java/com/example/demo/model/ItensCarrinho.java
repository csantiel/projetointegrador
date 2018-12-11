
package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ItensCarrinho {
    private Long id;
    private Produto produtos;
    private double quantidade;
    private Carrinho carrinho;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="produto")
    public Produto getProdutos() {
        return produtos;
    }


    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }


    public double getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="carrinho")
    public Carrinho getCarrinho() {
        return carrinho;
    }


    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    
    
    
}
