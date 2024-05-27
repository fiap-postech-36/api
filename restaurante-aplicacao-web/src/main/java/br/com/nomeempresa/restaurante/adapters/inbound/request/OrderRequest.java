package br.com.nomeempresa.restaurante.adapters.inbound.request;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record OrderRequest(
    Long id,
    @NotBlank
    List<ProdutoRequest> items) {
}
