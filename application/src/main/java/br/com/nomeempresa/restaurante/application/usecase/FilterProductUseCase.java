package br.com.nomeempresa.restaurante.application.usecase;

import br.com.nomeempresa.restaurante.application.inout.input.FilterInput;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilterProductUseCase implements UseCase<FilterInput, List<Product>> {
    @Override
    public Optional<List<Product>> execute(final Optional<FilterInput> filterParamOpt) {
        return Optional.empty();
    }
}
