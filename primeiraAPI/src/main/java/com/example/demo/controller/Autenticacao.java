
package com.example.demo.controller;


import com.example.demo.model.Cliente;
import com.example.demo.services.ClienteService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/login")
public class Autenticacao {
    public final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    
    @Autowired
    ClienteService clienteService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity autenticar(@RequestBody Cliente cli){
       Cliente cliAuth = clienteService.autenticarCliente(cli);
       
       if(cliAuth == null || cliAuth.getNome().equals("") || cliAuth.getSenha().equals("")){
           return new ResponseEntity(cliAuth, HttpStatus.FORBIDDEN);
       }
       
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(cliAuth.getNome());
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis()+10*60*1000));
        jwtBuilder.signWith(key);
        
        String token = jwtBuilder.compact();
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer"+token);
        
       return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
