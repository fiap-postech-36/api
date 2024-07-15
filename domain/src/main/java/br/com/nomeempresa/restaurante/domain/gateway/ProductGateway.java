package br.com.nomeempresa.restaurante.domain.gateway;


import br.com.nomeempresa.restaurante.domain.core.domain.entities.Category;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;

import java.util.Collection;

public interface ProductGateway {

    Product save(Product product);

    Product update(Product product);

    void delete(Long id);

    Product findById(Long id);

    Collection<Product> findByCategory(Category category);

    Collection<Product> findAll();
}
