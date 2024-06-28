package br.com.nomeempresa.restaurante.ports.out;

import br.com.nomeempresa.restaurante.core.domain.entities.Product;
import br.com.nomeempresa.restaurante.core.domain.entities.Category;

import java.util.Collection;

public interface ProductPort {

    Product save(Product product);

    Product update(Product product);

    void delete(Long id);

    Product findById(Long id);

    Collection<Product> findByCategory(Category category);

    Collection<Product> findAll();

}
