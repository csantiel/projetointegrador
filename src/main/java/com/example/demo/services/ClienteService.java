package com.example.demo.services;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    void cadastrarCliente(Cliente cli) {

    }

    void editarCliente(Cliente cli) {

    }

    void excluirCliente(Long id) {

    }

    void buscaCliente(Long id) {

    }

}
