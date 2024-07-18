package br.com.nomeempresa.restaurante.application.usecase.product;

import br.com.nomeempresa.restaurante.application.inout.input.FilterInput;
import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilterProductUseCase implements UseCase<FilterInput, Page<Product>> {
    @Override
    public Optional<Page<Product>> execute(final FilterInput filterParamOpt) {
        return Optional.empty();
    }
}
