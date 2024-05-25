package br.com.nomeempresa.restaurante.core.domain.entities;

import br.com.nomeempresa.restaurante.core.domain.valueObjects.CPF;

import java.io.Serializable;

public class Custumer implements Serializable {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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