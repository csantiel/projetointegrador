package com.example.demo.controller;

import com.example.demo.model.Imagem;
import com.example.demo.services.ImagemService;
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
@RequestMapping(value = "/imagem")
public class ImagemController {
    
    @Autowired
    ImagemService imagemService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarImagem(@RequestBody Imagem imag) {
        
        imagemService.cadastrarImagem(imag);
        
        return new ResponseEntity(HttpStatus.CREATED);
        
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void removerImagem(@PathVariable Long id) {
        imagemService.excluirImagem(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    void editarImagem(Imagem imag) {
        imagemService.editarImagem(imag);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    void mostraImagem(Long id) {
        imagemService.buscaImagem(id);
    }
}
