
package com.example.demo.model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Carrinho {
    private long id;
    private Collection<ItensCarrinho> itens;
    private Date expireTime;
    private Cliente cliente;
    
    
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="itens")
    public Collection<ItensCarrinho> getItens() {
        return itens;
    }


    public void setItens(Collection<ItensCarrinho> itens) {
        this.itens = itens;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    
    public Date getExpireTime() {
        return expireTime;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="cliente")
    public Cliente getCliente() {
        return cliente;
    }


    public void setId(long id) {
        this.id = id;
    }


    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
