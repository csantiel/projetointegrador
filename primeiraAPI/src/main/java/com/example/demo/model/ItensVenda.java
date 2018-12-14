
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ItensVenda {
    private Long id;
    private double custo;
    private Produto produto;
    private double quantidade;
    private double valor;
    private Venda venda;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public double getCusto() {
        return custo;
    }


    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    @JsonIgnore
    @ManyToOne()
    //@JoinColumn(name="produto_id")
    public Produto getProduto() {
        return produto;
    }


    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public double getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }


    public double getValor() {
        return valor;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }

    @ManyToOne()
    @JoinColumn(name="venda_id")
    public Venda getVenda() {
        return venda;
    }


    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
