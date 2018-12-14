
package com.example.demo.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda {
    private Long id;
    private Date data;
    private Cliente cliente;
    private double valor;
    private List<ItensVenda> itensVenda;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    //@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "venda")
    @OneToMany()
    @JoinColumn(name="venda_id")
    public List<ItensVenda> getItensVenda() {
        return itensVenda;
    }


    public void setItensVenda(List<ItensVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    @OneToOne
    public Cliente getCliente() {
        return cliente;
    }

    @Temporal(TemporalType.TIMESTAMP)
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
