package br.com.fiap.healthix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.healthix.model.Movimentacao;

public interface MovimentacaoRepository 
            extends JpaRepository<Movimentacao, Long> {
    
}