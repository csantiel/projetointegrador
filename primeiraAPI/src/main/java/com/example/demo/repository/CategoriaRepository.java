package com.example.demo.repository;

import com.example.demo.model.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public Categoria findByNome (@Param("nome")String nome);
}
