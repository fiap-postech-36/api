package br.com.nomeempresa.restaurante.domain.core.domain.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Product implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String urlImage;
    private BigDecimal price;
    private Category category;


}
