package com.example.demo.repository;

import com.example.demo.model.Carrinho;
import com.example.demo.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    public Carrinho findByCliente (@Param("cliente")Cliente cliente);
}
