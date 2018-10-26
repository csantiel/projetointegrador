package com.example.demo.repository;

import com.example.demo.model.Imagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {
    public Imagem findByNome (@Param("nome")String nome);
}
