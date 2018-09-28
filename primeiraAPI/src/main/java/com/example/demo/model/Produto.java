
package com.example.demo.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Produto {
    private long id;
    private String nome;
    private double preco;
    private double custo;
    private Categoria categoria;
    private int quantidade;
    private Collection<Imagem> imagens;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }


    public double getCusto() {
        return custo;
    }


    public void setCusto(double custo) {
        this.custo = custo;
    }


    public Categoria getCategoria() {
        return categoria;
    }


    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="produto")
    public Collection<Imagem> getImagens() {
        return imagens;
    }

    
    public void setImagens(Collection<Imagem> imagens) {
        this.imagens = imagens;
    }
}
