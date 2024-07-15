package br.com.nomeempresa.restaurante.application.usecase;

import br.com.nomeempresa.restaurante.application.inout.input.ProductInput;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditProductUseCase implements UseCase<ProductInput, Product> {
    @Override
    public Optional<Product> execute(Optional<ProductInput> in) {
        return Optional.empty();
    }
}
