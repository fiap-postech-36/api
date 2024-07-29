package br.com.nomeempresa.restaurante.domain.gateway;


import br.com.nomeempresa.restaurante.domain.core.domain.entities.Category;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductGateway {

    Optional<Product> save(final Product product);

    Optional<Product> update(final Product product);

    void delete(final Long id);

    Optional<Product> findById(final Long id);

    Collection<Product> findByCategory(final Category category);

    Collection<Product> filterByCategoryAndName(final String category, final String name);

    Collection<Product> findAll();
}
