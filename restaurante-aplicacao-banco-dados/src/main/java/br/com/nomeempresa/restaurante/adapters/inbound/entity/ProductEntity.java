package br.com.nomeempresa.restaurante.adapters.inbound.entity;

import br.com.nomeempresa.restaurante.adapters.inbound.types.CategoryType;
import br.com.nomeempresa.restaurante.core.domain.entities.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;

@Table(name = "produto")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column( name = "nome",nullable = false,unique=true,length=50)
    private String name;

    @Column( name = "descricao",nullable = false,length=500)
    private String description;

    @Column( name = "urlimagem",nullable = false,length=200)
    private String urlImage;

    @Column( name = "preco",nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Type(CategoryType.class)
    @Column( name = "categoria",nullable = false)
    private Category category;

}
