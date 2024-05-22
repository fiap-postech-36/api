package br.com.nomeempresa.restaurante.core.domain;

import java.io.Serializable;

public enum Categoria {
    LANCHE("LANCHE"),ACOPANHAMENTO("ACOPANHAMENTO"),BEBIDA("BEBIDA"),SOBREMESA("SOBREMESA");

    private final String code;

    Categoria(String categoria) {
        code = categoria;
    }

    public String getCode() {
        return code;
    }

    public static Categoria fromCode(String categoria) {
        if (categoria == null) {
            return null;
        }
        return switch (categoria) {
            case "LANCHE" -> Categoria.LANCHE;
            case "ACOPANHAMENTO" ->  Categoria.ACOPANHAMENTO;
            case "BEBIDA" ->  Categoria.BEBIDA;
            case "SOBREMESA" ->  Categoria.SOBREMESA;
            default -> throw new IllegalArgumentException("Categoria inválida");
        };
    }
}
