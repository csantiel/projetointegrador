package com.example.demo.services;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public void cadastrarProduto(Produto prod) {
        produtoRepository.save(prod);
    }

    public void editarProduto(Produto prod) {
        produtoRepository.save(prod);
    }

   public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

   public Produto buscaProduto(Long id) {
        return produtoRepository.findById(id).get();
    }

}
