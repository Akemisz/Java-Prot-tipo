package br.com.fiap.healthix.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.healthix.model.Categoria;
import br.com.fiap.healthix.repository.CategoriaRepository;

@RestController
@RequestMapping("categoria")

public class CategoriaController {
    
    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> index(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria create(@RequestBody Categoria categoria) {
        log.info("Cadastrando categoria: {}", categoria);
        categoriaRepository.save(categoria);
        return categoria;
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> get(@PathVariable Long id) {
       log.info("Buscar por id: {}", id);
       
       return categoriaRepository
       .findById(id)
       .map(ResponseEntity::ok)
       .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("Excluindo categoria {}", id);

        verificarSeExisteCategoria(id);

        categoriaRepository.deleteById(id);;
        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Categoria categoria){
        log.info("Atualizando categoria id {} para {}", id, categoria);
        
        verificarSeExisteCategoria(id);

        categoria.setId(id);
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(categoria);
    }


    private void verificarSeExisteCategoria(Long id){
        categoriaRepository
        .findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada")
        );

    }

}
