package br.com.nomeempresa.restaurante.application.inout.output;

public record CustomerOutput(
        Long id,
        String nome,
        String email){
}