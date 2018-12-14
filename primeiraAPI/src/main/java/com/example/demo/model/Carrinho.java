
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
    
    //CascadeType.REMOVE, apaga todos os itens do carrinho, quando o carrinho for apagado. Apagando o pai os filhos somem.
    //mappedBY indica qual o lado não dominante da relação. O contrário de JoinColumn
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "carrinho")
    //@JoinColumn(name="id_itens") Nao pode haver JoinColumn, pois n se pode criar uma coluna na tabela mestre de uma relação one to many
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
    @JoinColumn(name="cliente_id", unique = true)
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
