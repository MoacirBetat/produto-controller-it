package br.com.dbserver.api.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Produto {
    private Integer id;
    private String descricao;
    private String nome;
    private Double precoUnitario;
    private Integer quantidade;
}