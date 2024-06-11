package br.com.nomeempresa.restaurante.adapters.inbound.controllers;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConverterRequestDomain;
import br.com.nomeempresa.restaurante.adapters.inbound.request.ProductRequest;
import br.com.nomeempresa.restaurante.core.domain.entities.Category;
import br.com.nomeempresa.restaurante.core.domain.entities.Product;
import br.com.nomeempresa.restaurante.ports.in.ProductServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/produto")
@AllArgsConstructor
public class ProductController {

    private final ProductServicePort productServicePort;

    private final ConverterRequestDomain conversor;

    @PostMapping
    public Product saveProduct(@RequestBody @Valid ProductRequest produtoRequest){
        var produto = conversor.convertProductToDomain(produtoRequest);
        return productServicePort.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(name = "id",required = false) Long idProduto){
        productServicePort.delete(idProduto);
    }


    @PutMapping
    public Product updateProduct(@RequestBody @Valid ProductRequest produtoRequest){
        var produto = conversor.convertProductToDomain(produtoRequest);
        return productServicePort.update(produto);
    }

    @GetMapping("/{id}")
    public Product findByID(@PathVariable(name = "id",required = false) Long id) {
        return productServicePort.findById(id);
    }

    @GetMapping
    public Collection<Product> findAll(){
        return productServicePort.findAll();
    }

    @GetMapping("filtro")
    public Collection<Product> filter(@RequestParam(name = "categoria",required = false) Category categoria){

        if(categoria!=null){
            return productServicePort.findByCategory(categoria);
        }

        return Collections.EMPTY_LIST;
    }
}