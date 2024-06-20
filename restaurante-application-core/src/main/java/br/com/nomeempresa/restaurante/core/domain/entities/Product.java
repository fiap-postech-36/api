package br.com.nomeempresa.restaurante.core.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Product implements Serializable {

    private Long id;
    private String name, description, urlImage;
    private BigDecimal price;
    private Category category;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product other) {
            return Objects.equals(this.id, other.getId())
                || Objects.equals(this.name, other.getName())
                && Objects.equals(category.getCode(), other.getCategory().getCode());
        }
        return false;
    }

}
