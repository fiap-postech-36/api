package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.entities.Product;
import br.com.nomeempresa.restaurante.core.domain.entities.Category;
import br.com.nomeempresa.restaurante.ports.in.ProductServicePort;
import br.com.nomeempresa.restaurante.ports.out.ProductPort;

import java.util.Collection;

public class ProductService implements ProductServicePort {

    private final ProductPort productPor;


    public ProductService(ProductPort produtoPort) {
        this.productPor = produtoPort;

    }

    @Override
    public Product save(Product product){
        return this.productPor.save(product);
    }

    @Override
    public Product update(Product product){
        return this.productPor.update(product);

    }

    @Override
    public void delete(Long id){
         this.productPor.delete(id);
    }

    @Override
    public Product findById(Long id){
        return this.productPor.findById(id);

    }

    @Override
    public Collection<Product> findByCategory(Category category){
        return this.productPor.findByCategory(category);

    }

    @Override
    public Collection<Product> findAll(){
        return this.productPor.findAll();
    }


}