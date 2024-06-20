package br.com.nomeempresa.restaurante.adapters.inbound.request;


import br.com.nomeempresa.restaurante.core.domain.entities.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
        Long id,
        @NotBlank(message = "Nome é obrigatório. Quantidade máxima de caracteres 100.") String name,

        @NotBlank(message = "Descrição é obrigatório. Quantidade máxima de caracteres 500.") String description,

        @NotBlank(message = "URL da imagem é obrigatório") String urlImage,

        @NotNull(message = "Preço é obrigatório")
        @DecimalMin(message = "Menor valor é zero", value = "1.0", inclusive = true)
        BigDecimal price,

        @NotNull(message = "Catégoria é obrigatório")
        Category category){

}
