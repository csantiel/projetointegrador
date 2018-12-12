package com.example.demo.services;

import com.example.demo.model.FileStorageProperties;
import com.example.demo.model.Imagem;
import com.example.demo.model.Produto;
import com.example.demo.repository.ImagemRepository;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
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
        String fullname = file.getOriginalFilename();
        String ext = "";
        
        int i = fullname.lastIndexOf('.');
        
        if(i == -1){
            throw new IOException ("Arquivo sem extensão valida");
            
        }
        if(i >= 0){
            ext = fullname.substring(i);
        }
        return UUID.randomUUID()+ext;
    }
    
    public void storeImagem(MultipartFile file, Produto p) throws IOException {
        String relativePath = generatePath ()+ generateUUIDandExtension(file);
        Path absolutePath;
        absolutePath = Paths.get(
        fileStorageLocation.toString()
        +relativePath).toAbsolutePath().normalize();
        
        try{
            Files.createDirectories(absolutePath);
            Files.copy(file.getInputStream(),absolutePath, StandardCopyOption.REPLACE_EXISTING);
            
            //Nos slides é mostrado o método setPatch, porém no diagrama a variavel é path, logo acredito que o metodo tenha o nome errado
            Imagem img = new Imagem();
            img.setPath(relativePath);
            img.setProduto(p);
            
            imagemRepository.save(img);   
        } catch (IOException e){
            System.out.println("Erro: "+e);
        }
    }
    
    public Resource carregaImgId(Long id) throws FileNotFoundException{
        Imagem img = imagemRepository.findById(id).get();
        
        try{
            if(img == null){
                throw new FileNotFoundException("Arquivo nao encontrado");
            }
            Path imgpath = Paths.get(fileStorageLocation.toString()+img.getPath()).toAbsolutePath().normalize();
            
            Path fullPath = this.fileStorageLocation.resolve(imgpath).normalize();
            
            Resource resource = new UrlResource(fullPath.toUri());
            if(resource.exists()){
                return resource;
            }
        } catch (NoSuchElementException | MalformedURLException e){
            throw new FileNotFoundException("Arquivo não encontrado");
        }
        throw new FileNotFoundException("Arquivo nao encontrado");
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