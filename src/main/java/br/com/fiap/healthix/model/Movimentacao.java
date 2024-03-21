package br.com.fiap.healthix.model;

import br.com.fiap.healthix.validation.TipoMovimentacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Movimentacao {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @TipoMovimentacao(message = "{movimentacao.tipo.tipomovimentacao}")
    private String tipo; // ENTRADA | SAIDA

    @NotBlank(message = "{movimentacao.descricao.notblank}")
    @Size(min = 3, message =  "{movimentacao.descricao.size}")
    private String descricao;


    // @TipoMovimentacao(message = "{movimentacao.tipo.tipomovimentacao}")
    // private String tipo; // ENTRADA | SAIDA

    
}