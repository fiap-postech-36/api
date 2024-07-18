package br.com.nomeempresa.restaurante.application.usecase.product;

import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetByIdProductUseCase implements UseCase<Long, Product> {
    @Override
    public Optional<Product> execute(Long id) {
        return Optional.empty();
    }
}
