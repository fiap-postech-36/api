package br.com.nomeempresa.restaurante.application.usecase.payment;

import br.com.nomeempresa.restaurante.application.inout.input.PaymentUpdateInput;
import br.com.nomeempresa.restaurante.application.inout.mapper.PaymentInputOutputMapper;
import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdatePaymentUseCase  implements UseCase<PaymentUpdateInput, Payment> {

    private final PaymentGateway paymentGateway;

    @Override
    public Optional<Payment> execute(PaymentUpdateInput paymentUpdateInput) {
        return paymentGateway.update(PaymentInputOutputMapper.INSTANCE.paymentUpdateRequestToPayment(paymentUpdateInput));
    }

}
