
package com.example.demo.model;

import java.util.Collection;
import javax.persistence.Entity;

@Entity
public class Estoque {
    private Collection<Produto> produtos;


    public Collection<Produto> getProdutos() {
        return produtos;
    }


    public void setProdutos(Collection<Produto> produtos) {
        this.produtos = produtos;
    }
    
}
