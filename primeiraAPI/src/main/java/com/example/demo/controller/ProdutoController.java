package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.services.ProdutoService;
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
@RequestMapping(value = "/produto")
public class ProdutoController {
    
    @Autowired
    ProdutoService produtoService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarProduto(@RequestBody Produto prod) {
        
        produtoService.cadastrarProduto(prod);
        
        return new ResponseEntity(HttpStatus.CREATED);
        
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void removerProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    void editarProduto(Produto prod) {
        produtoService.editarProduto(prod);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    void mostraProduto(Long id) {
        produtoService.buscaProduto(id);
    }
}
