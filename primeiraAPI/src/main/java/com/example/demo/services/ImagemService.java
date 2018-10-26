package com.example.demo.services;

import com.example.demo.model.Imagem;
import com.example.demo.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagemService {

    @Autowired
    ImagemRepository imagemRepository;

    public void cadastrarImagem(Imagem imag) {
        imagemRepository.save(imag);
    }

    public void editarImagem(Imagem imag) {
        imagemRepository.save(imag);
    }

   public void excluirImagem(Long id) {
        imagemRepository.deleteById(id);
    }

   public Imagem buscaImagem(Long id) {
        return imagemRepository.findById(id).get();
    }

}
