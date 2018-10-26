package com.example.demo.repository;

import com.example.demo.model.Cliente;
import com.example.demo.model.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    public Venda findByCliente (@Param("cliente")Cliente cliente);
}
