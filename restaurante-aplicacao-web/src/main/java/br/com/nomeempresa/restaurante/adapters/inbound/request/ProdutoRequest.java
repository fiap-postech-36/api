package br.com.nomeempresa.restaurante.adapters.inbound.request;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CategoriaEnum;
import br.com.nomeempresa.restaurante.core.domain.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProdutoRequest(
        Long id,
        @NotBlank(message = "Nome é obrigatório. Quantidade máxima de caracteres 100.") String nome,

        @NotBlank(message = "Descrição é obrigatório. Quantidade máxima de caracteres 500.") String descricao,

        @NotBlank(message = "URL da imagem é obrigatório") String urlImagem,

        @NotBlank(message = "Preçoe é obrigatório")
        @DecimalMin(message = "Menor valor é zero", value = "1.0", inclusive = true)
        BigDecimal preco,

        @NotBlank(message = "Catégoria é obrigatório")
        Categoria categoria){

}
