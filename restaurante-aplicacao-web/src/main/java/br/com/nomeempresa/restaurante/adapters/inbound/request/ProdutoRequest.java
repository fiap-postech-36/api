package br.com.nomeempresa.restaurante.adapters.inbound.request;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CategoriaEnum;
import br.com.nomeempresa.restaurante.core.domain.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ProdutoRequest(
        Long id,
        @NotBlank String nome,
        @NotBlank String descricao,
        @NotBlank String urlImagem, double preco, Categoria categoria){

}
