package br.com.nomeempresa.restaurante.adapters.inbound.entity;

public enum CategoriaEnum {

    LANCHE("LANCHE"),ACOPANHAMENTO("ACOPANHAMENTO"),BEBIDA("BEBIDA"),SOBREMESA("SOBREMESA");

    private final String code;

    CategoriaEnum(String categoria) {
        code = categoria;
    }

    public String getCode() {
        return code;
    }

    public static CategoriaEnum fromCode(String categoria) {
        if (categoria == null) {
            return null;
        }
        return switch (categoria) {
            case "LANCHE" -> CategoriaEnum.LANCHE;
            case "ACOPANHAMENTO" ->  CategoriaEnum.ACOPANHAMENTO;
            case "BEBIDA" ->  CategoriaEnum.BEBIDA;
            case "SOBREMESA" ->  CategoriaEnum.SOBREMESA;
            default -> throw new IllegalArgumentException("Categoria inválida");
        };
    }
}
