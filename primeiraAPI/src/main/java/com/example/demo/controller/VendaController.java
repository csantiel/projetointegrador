package com.example.demo.controller;

import com.example.demo.model.Venda;
import com.example.demo.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/venda")
public class VendaController {
    
    @Autowired
    VendaService vendaService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarVenda(@RequestBody Venda vend) {
        
        vendaService.cadastrarVenda(vend);
        
        return new ResponseEntity(HttpStatus.CREATED);
        
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void removerVenda(@PathVariable Long id) {
        //System.out.println("apaga venda" + id);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    void editarVenda(Venda vend) {
        vendaService.editarVenda(vend);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    void mostraVenda(Long id) {
        vendaService.buscaVenda(id);
    }
}
