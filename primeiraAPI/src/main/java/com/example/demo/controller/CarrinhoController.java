package com.example.demo.controller;

import com.example.demo.model.Carrinho;
import com.example.demo.services.CarrinhoService;
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
@RequestMapping(value = "/carrinho")
public class CarrinhoController {
    
    @Autowired
    CarrinhoService carrinhoService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarCarrinho(@RequestBody Carrinho car) {
        carrinhoService.cadastrarCarrinho(car);
        
        
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject("car_id: "+car.getId()+" cli_id: "+car.getCliente().getId());
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis()+10*60*1000));
        jwtBuilder.signWith(Autenticacao.key);
        
        String token = jwtBuilder.compact();
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+token);
        
       return new ResponseEntity<>(headers, HttpStatus.CREATED);
        
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
