package br.com.nomeempresa.restaurante.adapters.inbound.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UsuarioRequest {

    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String cpf;

    @Email
    private String email;

}