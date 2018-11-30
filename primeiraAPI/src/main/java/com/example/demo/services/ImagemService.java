package com.example.demo.services;

import com.example.demo.model.FileStorageProperties;
import com.example.demo.model.Imagem;
import com.example.demo.model.Produto;
import com.example.demo.repository.ImagemRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagemService {
    private final Path fileStorageLocation;
    
    @Autowired
    ImagemRepository imagemRepository;
    
    ImagemService(FileStorageProperties fsp){
        this.fileStorageLocation = Paths.get(fsp.getUploadDir()).toAbsolutePath().normalize();
        
        try{
            Files.createDirectories(fileStorageLocation);
        } catch(IOException e){
            System.out.println("Não foi possivel criar o diretorio"+e);
        }
    }
    
    private String generatePath(){
        String path;
        
        LocalDateTime dateTime;
        dateTime = LocalDateTime.now();
        path = "/"+dateTime.getYear()+"/"+dateTime.getMonth()+"/"+"/"+dateTime.getDayOfMonth()+"/";
        return path;
    }
    
    private String generateUUIDandExtension(MultipartFile file) throws IOException {
        String fullname = file.getOringinalFilename();
        String ext = "";
        
        int i = fullname.lastIndexOf('.');
        
        if(i == -1){
            throws new IOException ("Arquivo sem extensão valida");
            
        }
        if(i >= 0){
            ext = fullname.substring(i);
        }
        return UUID.randomUUID()+ext;
    }
    
    public void storeImagem(MultipartFile file, Produto p) throws IOException {
        String relativePath = generatePath ()+ generateUUIDandExtension(file);
        Path absolutePath;
        absolutePath = Path.get(
        fileStorageLocation.toString()
        +relativePath).toAbsolutePath().normalize();
        
        try{
            Files.createDiretories(absolutePath);
            Files.copy(file.getInputStream(),absolutePath, StandardCopyOption.REPLACE_EXISTING);
            
            Imagem img = new Imagem();
            img.setPatch(relativePath);
            img.setProduto(p);
            
            imagemRepository.save(img);   
        } catch (IOException e){
            System.out.println("Erro: "+e);
        }
    }
    
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
