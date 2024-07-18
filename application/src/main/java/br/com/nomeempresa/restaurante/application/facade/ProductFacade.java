package br.com.nomeempresa.restaurante.application.facade;

import br.com.nomeempresa.restaurante.application.exception.NoResourceFoundException;
import br.com.nomeempresa.restaurante.application.inout.input.FilterInput;
import br.com.nomeempresa.restaurante.application.inout.input.OrderInput;
import br.com.nomeempresa.restaurante.application.inout.input.ProductInput;
import br.com.nomeempresa.restaurante.application.inout.mapper.PaymentInputOutputMapper;
import br.com.nomeempresa.restaurante.application.inout.mapper.ProductInputOutputMapper;
import br.com.nomeempresa.restaurante.application.inout.output.OrderOutput;
import br.com.nomeempresa.restaurante.application.inout.output.ProductOutput;
import br.com.nomeempresa.restaurante.application.usecase.order.CreateOrderUseCase;
import br.com.nomeempresa.restaurante.application.usecase.order.DeleteOrderUseCase;
import br.com.nomeempresa.restaurante.application.usecase.order.EditOrderUseCase;
import br.com.nomeempresa.restaurante.application.usecase.order.FilterOrderUseCase;
import br.com.nomeempresa.restaurante.application.usecase.order.GetByIdOrderUseCase;
import br.com.nomeempresa.restaurante.application.usecase.product.CreateProductUseCase;
import br.com.nomeempresa.restaurante.application.usecase.product.DeleteProductUseCase;
import br.com.nomeempresa.restaurante.application.usecase.product.EditProductUseCase;
import br.com.nomeempresa.restaurante.application.usecase.product.FilterProductUseCase;
import br.com.nomeempresa.restaurante.application.usecase.product.GetByIdProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFacade {

    private final CreateProductUseCase createProductUseCase;
    private final EditProductUseCase editProductUseCase;
    private final FilterProductUseCase filterProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final GetByIdProductUseCase getByIdProductUseCase;

    public ProductOutput create(final ProductInput productInput) {
        final var productOutPut = createProductUseCase.execute(productInput);
        return ProductInputOutputMapper.INSTANCE.productToProductResponse(productOutPut.orElse(null));
    }

    public ProductOutput update(final ProductInput productInput) {
        final var productOutPut = editProductUseCase.execute(productInput);
        return ProductInputOutputMapper.INSTANCE.productToProductResponse(productOutPut.orElse(null));
    }

    public Page<ProductOutput> filter(final FilterInput filterInput) {
        final var page = filterProductUseCase.execute(filterInput).orElse(Page.empty());
        final var content = page.getContent().stream()
            .map(ProductInputOutputMapper.INSTANCE::productToProductResponse)
            .toList();

        return new PageImpl<>(content, page.getPageable(), page.getTotalElements());
    }

    public void delete(final Long id) {
        deleteProductUseCase.execute(id);
    }

    public ProductOutput get(final Long id) {
        return ProductInputOutputMapper.INSTANCE.productToProductResponse(getByIdProductUseCase.execute(id)
            .orElseThrow(NoResourceFoundException::new));
    }

}
