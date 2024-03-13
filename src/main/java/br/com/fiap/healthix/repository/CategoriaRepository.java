package br.com.fiap.healthix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.healthix.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    
}