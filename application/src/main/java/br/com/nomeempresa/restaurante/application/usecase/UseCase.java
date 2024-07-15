package br.com.nomeempresa.restaurante.application.usecase;

import jakarta.validation.Valid;

import java.util.Optional;

/**
 I = INPUT
 O = OUTPUT
 **/
public interface UseCase<I, O> {

    Optional<O> execute(final @Valid Optional<I> in);
}
