package com.example.demo.controller;

import com.example.demo.model.Carrinho;
import com.example.demo.services.CarrinhoService;
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
@RequestMapping(value = "/carrinho")
public class CarrinhoController {
    
    @Autowired
    CarrinhoService carrinhoService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarCarrinho(@RequestBody Carrinho car) {
        
        carrinhoService.cadastrarCarrinho(car);
        
        return new ResponseEntity(HttpStatus.CREATED);
        
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void removerCarrinho(@PathVariable Long id) {
        carrinhoService.excluirCarrinho(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    void editarCarrinho(Carrinho car) {
        carrinhoService.editarCarrinho(car);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    void mostraCarrinho(Long id) {
        carrinhoService.buscaCarrinho(id);
    }
}
