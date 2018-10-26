package com.example.demo.repository;

import com.example.demo.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public Produto findByNome (@Param("nome")String nome);
}
