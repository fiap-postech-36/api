package br.com.nomeempresa.restaurante.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteProductUseCase implements UseCase<Long, Void> {
    @Override
    public Optional<Void> execute(final Optional<Long> idOpt) {
        return Optional.empty();
    }
}
