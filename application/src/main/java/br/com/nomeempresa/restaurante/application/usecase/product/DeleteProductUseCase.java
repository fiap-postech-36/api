package br.com.nomeempresa.restaurante.application.usecase.product;

import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteProductUseCase implements UseCase<Long, Void> {
    @Override
    public Optional<Void> execute(final Long idOpt) {
        return Optional.empty();
    }
}
