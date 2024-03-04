package br.com.fiap.healthix.model;

import java.util.Random;

public record Categoria(Long id, String nome, String descricao) {


    public Categoria(Long id, String nome, String descricao){

        var key = (id != null) ? id : Math.abs( new Random().nextLong() );
        this.id = key;
        this.nome = nome;
        this.descricao = descricao;
    
    }
    
}



