package br.com.nomeempresa.restaurante.core.domain.entities;

public enum Category {
    LANCHE("LANCHE"),ACOPANHAMENTO("ACOPANHAMENTO"),BEBIDA("BEBIDA"),SOBREMESA("SOBREMESA");

    private final String code;

    Category(String category) {
        code = category;
    }

    public String getCode() {
        return code;
    }

    public static Category fromCode(String category) {
        if (category == null) {
            return null;
        }
        return switch (category) {
            case "LANCHE" -> Category.LANCHE;
            case "ACOPANHAMENTO" ->  Category.ACOPANHAMENTO;
            case "BEBIDA" ->  Category.BEBIDA;
            case "SOBREMESA" ->  Category.SOBREMESA;
            default -> throw new IllegalArgumentException("Categoria inválida");
        };
    }
}
