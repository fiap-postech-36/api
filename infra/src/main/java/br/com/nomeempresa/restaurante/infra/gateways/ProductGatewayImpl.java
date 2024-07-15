package br.com.nomeempresa.restaurante.infra.gateways;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Category;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;
import br.com.nomeempresa.restaurante.domain.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class ProductGatewayImpl implements ProductGateway {
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Collection<Product> findByCategory(Category category) {
        return null;
    }

    @Override
    public Collection<Product> findAll() {
        return null;
    }
}
