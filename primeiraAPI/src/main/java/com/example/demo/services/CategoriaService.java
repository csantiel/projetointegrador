package com.example.demo.services;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public void cadastrarCategoria(Categoria cat) {
        categoriaRepository.save(cat);
    }

    public void editarCategoria(Categoria cat) {
        categoriaRepository.save(cat);
    }

   public void excluirCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

   public Categoria buscaCategoria(Long id) {
        return categoriaRepository.findById(id).get();
    }

}
