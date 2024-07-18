package br.com.nomeempresa.restaurante.application.usecase.payment;

import br.com.nomeempresa.restaurante.application.inout.input.FilterInput;
import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilterPaymentUseCase implements UseCase<FilterInput, Page<Payment>> {

    private final PaymentGateway paymentGateway;
    @Override
    public Optional<Page<Payment>> execute(final FilterInput filterInput) {
        return Optional.empty();
    }
}
