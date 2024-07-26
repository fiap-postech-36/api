package br.com.nomeempresa.restaurante.application.usecase.payment;

import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.domain.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckoutPaymentUseCase implements UseCase<Long, StatusPayment> {

    private final PaymentGateway paymentGateway;

    @Override
    public Optional<StatusPayment> execute(final Long orderId) {
        return Optional.empty();
    }
}
