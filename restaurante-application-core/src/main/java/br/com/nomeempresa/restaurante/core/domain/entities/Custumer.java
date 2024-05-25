package br.com.nomeempresa.restaurante.core.domain.entities;

import br.com.nomeempresa.restaurante.core.domain.valueObjects.CPF;

import java.io.Serializable;

public class Custumer implements Serializable {

    private Long id;

    private String name;

    private CPF cpf;

    private String email;

    public Custumer(Long id, String name, CPF cpf, String Email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = Email;
    }

    public Custumer(){}

    public Boolean isIdentified() {
        return !this.cpf.isEmpty();
    }
}