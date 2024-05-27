package br.com.nomeempresa.restaurante.core.domain.valueObjects;

public class CPF {
    private String cpf;

    public CPF(String cpf){
        this.cpf = cpf;
    }

    public String getValue() {
        return cpf;
    }
}