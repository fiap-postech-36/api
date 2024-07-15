package br.com.nomeempresa.restaurante.application.controllers;

import br.com.nomeempresa.restaurante.application.inout.mapper.ProductRequestResponseMapper;
import br.com.nomeempresa.restaurante.application.inout.input.ProductInput;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Category;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;
import br.com.nomeempresa.restaurante.domain.gateway.ProductGateway;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/produto")
@AllArgsConstructor
public class ProductController {

    private final ProductGateway productGateway;

    @PostMapping
    public Product saveProduct(@RequestBody @Valid final ProductInput productInput){
        final var product = ProductRequestResponseMapper.INSTANCE.productRequestToProduct(productInput);
        return productGateway.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(name = "id",required = false) Long idProduct){
        productGateway.delete(idProduct);
    }


    @PutMapping
    public Product updateProduct(@RequestBody @Valid ProductInput productInput){
        final var product = ProductRequestResponseMapper.INSTANCE.productRequestToProduct(productInput);
        return productGateway.update(product);
    }

    @GetMapping("/{id}")
    public Product findByID(@PathVariable(name = "id",required = false) Long id) {
        return productGateway.findById(id);
    }

    @GetMapping
    public Collection<Product> findAll(){
        return productGateway.findAll();
    }

    @GetMapping("filtro")
    public Collection<Product> filter(@RequestParam(name = "categoria",required = false) Category categoria){

        if(categoria!=null){
            return productGateway.findByCategory(categoria);
        }

        return Collections.EMPTY_LIST;
    }
}