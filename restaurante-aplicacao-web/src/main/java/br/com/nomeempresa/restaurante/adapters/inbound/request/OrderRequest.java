package br.com.nomeempresa.restaurante.adapters.inbound.request;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record OrderRequest(
    @NotBlank
    List<ProdutoRequest> items) {
}
