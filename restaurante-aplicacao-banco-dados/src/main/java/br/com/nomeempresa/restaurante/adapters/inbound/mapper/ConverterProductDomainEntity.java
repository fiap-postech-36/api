package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProductEntity;
import br.com.nomeempresa.restaurante.core.domain.entities.Category;
import br.com.nomeempresa.restaurante.core.domain.entities.Product;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Component
public class ConverterProductDomainEntity {


    public ProductEntity converterParaEntidade(Product produto) {
        ProductEntity produtoEntity = new ProductEntity();
        produtoEntity.setId(produto.getId());
        produtoEntity.setName(produto.getName());
        produtoEntity.setDescription(produto.getDescription());
        produtoEntity.setPrice(produto.getPrice());
        produtoEntity.setUrlImage(produto.getUrlImage());
        produtoEntity.setCategory(Category.fromCode(produto.getCategory().name()));
        return produtoEntity;
    }

    public Collection<Product> converterColecaoParaDominio(Collection<ProductEntity> produtosEntity) {
        return Optional.ofNullable(produtosEntity)
                .map(entities -> entities.stream()
                        .map(this::converterParaDominioComTratamento)
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }

    public Product converterParaDominioComTratamento(ProductEntity produtoEntity) {
        try {
            return converterParaDominio(produtoEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Product converterParaDominio(ProductEntity produtoEntity) {
        Product produto = new Product();
        produto.setId(produtoEntity.getId());
        produto.setName(produtoEntity.getName());
        produto.setPrice(produtoEntity.getPrice());
        produto.setDescription(produtoEntity.getDescription());
        produto.setUrlImage(produtoEntity.getUrlImage());
        produto.setCategory(Category.fromCode(produtoEntity.getCategory().name()));
        return produto;
    }

    public Product converterParaDominio(Optional<ProductEntity> produtoEntity) {
        return produtoEntity.map(this::converterParaDominioComTratamento).orElse(null);
    }

}
