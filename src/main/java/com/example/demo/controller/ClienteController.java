package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @RequestMapping(method = RequestMethod.POST)
    void cadastrarCliente() {
        System.out.println("cadastra");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    void removerCliente() {
        System.out.println("apaga");
    }

    @RequestMapping(method = RequestMethod.PUT)
    void editarCliente() {
        System.out.println("edita");
    }

    
    
    @RequestMapping(method = RequestMethod.GET)
    void mostraCliente() {
        System.out.println("mostra");
    }

}
