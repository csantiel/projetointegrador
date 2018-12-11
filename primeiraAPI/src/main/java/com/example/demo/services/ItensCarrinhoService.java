package com.example.demo.services;

import com.example.demo.model.ItensCarrinho;
import com.example.demo.repository.ItensCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItensCarrinhoService {
    @Autowired
    ItensCarrinhoRepository itensCarrinhoRepository;
    
    public void cadastrarItemCarrinho(ItensCarrinho ic) {
        itensCarrinhoRepository.save(ic);
    }

    public void editarItemCarrinho(ItensCarrinho ic) {
        itensCarrinhoRepository.save(ic);
    }

   public void excluirItemCarrinho(Long id) {
        itensCarrinhoRepository.deleteById(id);
    }

   public ItensCarrinho buscaItemCarrinho(Long id) {
        return itensCarrinhoRepository.findById(id).get();
    }
}
