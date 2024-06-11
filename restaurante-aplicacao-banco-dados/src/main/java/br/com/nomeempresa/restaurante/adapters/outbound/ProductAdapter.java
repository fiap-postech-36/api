package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProductEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConverterProductDomainEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConverterCategoryDomainEntity;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.ProductRepository;
import br.com.nomeempresa.restaurante.core.domain.entities.Category;
import br.com.nomeempresa.restaurante.core.domain.entities.Product;
import br.com.nomeempresa.restaurante.ports.out.ProductPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;


@Component
@AllArgsConstructor
public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    private final ConverterProductDomainEntity converterProduct;
    private final ConverterCategoryDomainEntity conversorCategoria;

    @Override
    @Transactional
    public Product save(Product produto) {
        var produtoEntity = converterProduct.converterParaEntidade(produto);
        return converterProduct.converterParaDominio(productRepository.save(produtoEntity));
    }

    @Override
    @Transactional
    public Product update(Product produto) {
        ProductEntity productEntity = productRepository
          .findById(produto.getId())
          .orElseThrow();

        productEntity.setName(produto.getName());
        productEntity.setDescription(produto.getDescription());
        productEntity.setPrice(produto.getPrice());
        productEntity.setUrlImage(produto.getUrlImage());
        return converterProduct.converterParaDominio(productRepository.save(productEntity));
    } 

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return converterProduct
          .converterParaDominio(productRepository.findById(id)
          .orElseThrow());
    }

    @Override
    public Collection<Product> findByCategory(Category categoria) {
        Category categoriaEntidade= conversorCategoria.converterParaEntidade(categoria);
        return converterProduct.converterColecaoParaDominio(productRepository.findByCategory(categoriaEntidade));
    }

    @Override
    public Collection<Product> findAll() {
        List<ProductEntity> produtosEntity = productRepository.findAll();
        return converterProduct.converterColecaoParaDominio(produtosEntity);
    }
}
