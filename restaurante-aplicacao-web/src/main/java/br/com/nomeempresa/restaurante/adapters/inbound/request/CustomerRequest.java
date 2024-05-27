package br.com.nomeempresa.restaurante.adapters.inbound.request;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerRequest(
        Long id,
        String nome,
        @CPF String cpf,
        @Email String email){
}