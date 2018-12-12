
package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.model.ItensCarrinho;
import com.example.demo.services.ClienteService;
import com.example.demo.services.ItensCarrinhoService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/itensCarrinhos")
public class ItensCarrinhoController {
        
    @Autowired
    ItensCarrinhoService itensCarrinhoService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarItensCarrinho(@RequestBody ItensCarrinho ic) {
        itensCarrinhoService.cadastrarItemCarrinho(ic);
        
        return new ResponseEntity(HttpStatus.CREATED);
        
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void removerItensCarrinho(@PathVariable Long id) {
        itensCarrinhoService.excluirItemCarrinho(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    void editarItensCarrinho() {
        System.out.println("edita");
    }
    
    @RequestMapping(method = RequestMethod.GET)
    void mostraItensCarrinho(long id) {
        itensCarrinhoService.buscaItemCarrinho(id);
    }
}
