package br.com.nomeempresa.restaurante.application.usecase;

import br.com.nomeempresa.restaurante.application.exception.NoInputPresent;
import br.com.nomeempresa.restaurante.application.inout.input.ProductInput;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;
import br.com.nomeempresa.restaurante.domain.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewProductUseCase implements UseCase<ProductInput, Product> {

    private final ProductGateway productGateway;
    @Override
    public Optional<Product> execute(final Optional<ProductInput> productInputOpt) {
        final var productInput = productInputOpt.orElseThrow(NoInputPresent::new);
        return Optional.empty();
    }
}
