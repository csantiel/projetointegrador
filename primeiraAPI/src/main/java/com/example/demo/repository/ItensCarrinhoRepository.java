package com.example.demo.repository;

import com.example.demo.model.ItensCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface ItensCarrinhoRepository extends JpaRepository<ItensCarrinho, Long>{
    public ItensCarrinho findById (@Param("id")String nome);
}
