package com.example.demo.controller;

import com.example.demo.model.Categoria;
import com.example.demo.services.CategoriaService;
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
@RequestMapping(value = "/categoria")
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarCategoria(@RequestBody Categoria cat) {
        
        categoriaService.cadastrarCategoria(cat);
        
        return new ResponseEntity(HttpStatus.CREATED);
        
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void removerCategoria(@PathVariable Long id) {
        categoriaService.excluirCategoria(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    void editarCategoria(Categoria cat) {
        categoriaService.editarCategoria(cat);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    void mostraCategoria(Long id) {
        categoriaService.buscaCategoria(id);
    }
}
