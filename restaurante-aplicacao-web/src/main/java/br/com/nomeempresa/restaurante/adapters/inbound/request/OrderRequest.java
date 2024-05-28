package br.com.nomeempresa.restaurante.adapters.inbound.request;



import java.util.List;

public record OrderRequest(
    Long id,
    List<Long> products) {
}
