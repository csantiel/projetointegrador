package com.example.demo.controller;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/login")
public class Autenticacao {
    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    
}
