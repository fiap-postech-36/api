package br.com.nomeempresa.restaurante.core.domain.entities;

import br.com.nomeempresa.restaurante.core.domain.valueObjects.CPF;

import java.io.Serializable;

public class Customer implements Serializable {

    private Long id;

    private String name;

    private CPF cpf;

    private String email;

    public Customer(Long id, String name, CPF cpf, String Email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = Email;
    }

    public Customer(){
        this.name = "";
        this.email = "";
        this.cpf = new CPF("");
    }

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

    public Boolean isIdentified() {
        return !this.cpf.getValue().isEmpty();
    }
}