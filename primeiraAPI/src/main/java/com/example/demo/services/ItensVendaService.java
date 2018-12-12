package com.example.demo.services;

import com.example.demo.model.ItensVenda;
import com.example.demo.repository.ItensVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItensVendaService {
     @Autowired
    ItensVendaRepository itensVendaRepository;
    
    public void cadastrarItemvenda(ItensVenda iv) {
        itensVendaRepository.save(iv);
    }

    public void editarItemvenda(ItensVenda iv) {
        itensVendaRepository.save(iv);
    }

   public void excluirItemVenda(Long id) {
        itensVendaRepository.deleteById(id);
    }

   public ItensVenda buscaItemVenda(Long id) {
        return itensVendaRepository.findById(id).get();
    }
}
