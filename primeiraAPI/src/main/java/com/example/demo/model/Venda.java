
package com.example.demo.model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Venda {
    private Long id;
    private Collection<Produto> produtos;
    private Cliente cliente;
    private Date data;
    private double valor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="produtos")
    public Collection<Produto> getProdutos() {
        return produtos;
    }


    public void setProdutos(Collection<Produto> produtos) {
        this.produtos = produtos;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="cliente")
    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Date getData() {
        return data;
    }


    public void setData(Date data) {
        this.data = data;
    }


    public double getValor() {
        return valor;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
