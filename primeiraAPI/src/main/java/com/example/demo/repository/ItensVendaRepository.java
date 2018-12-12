
package com.example.demo.repository;

import com.example.demo.model.ItensVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface ItensVendaRepository extends JpaRepository<ItensVenda, Long>{
    public ItensVenda findById (@Param("id")long id);
}
