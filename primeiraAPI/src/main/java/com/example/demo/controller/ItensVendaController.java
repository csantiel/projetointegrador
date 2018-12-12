package com.example.demo.controller;

import com.example.demo.model.ItensVenda;
import com.example.demo.services.ItensVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class ItensVendaController {
    @Autowired
    ItensVendaService itensVendaService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarItensCarrinho(@RequestBody ItensVenda iv) {
        itensVendaService.cadastrarItemvenda(iv);
        
        return new ResponseEntity(HttpStatus.CREATED);
        
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void removerItensCarrinho(@PathVariable Long id) {
        itensVendaService.excluirItemVenda(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    void editarItensCarrinho() {
        System.out.println("edita");
    }
    
    @RequestMapping(method = RequestMethod.GET)
    void mostraItensCarrinho(long id) {
       // itensCarrinhoService.buscaItemCarrinho(id);
    }
}
