package br.com.nomeempresa.restaurante.application.usecase.payment;

import br.com.nomeempresa.restaurante.application.exception.ResourceNotFound;
import br.com.nomeempresa.restaurante.application.inout.input.PaymentInput;
import br.com.nomeempresa.restaurante.application.inout.mapper.PaymentInputOutputMapper;
import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.QrCode;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.domain.gateway.OrderGateway;
import br.com.nomeempresa.restaurante.domain.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreatePaymentUseCase implements UseCase<PaymentInput, Payment> {

    private final IntegrationPaymentUseCase integrationPaymentUseCase;

    private final PaymentGateway paymentGateway;

    private final OrderGateway orderGateway;

    @Override
    public Optional<Payment> execute(final PaymentInput paymentInput) {
        Payment payment = PaymentInputOutputMapper.INSTANCE.paymentRequestToPayment(paymentInput);

        Order order = orderGateway.findById(paymentInput.order()).orElseThrow(ResourceNotFound::new);

        payment.setAmount(order.calculateTotal());

        payment.setStatusPending();
        Optional<Payment> paymentGenerated = paymentGateway.save(payment);

        if (paymentGenerated.isPresent()) {
            Optional<QrCode> qrCode = integrationPaymentUseCase.execute(paymentInput);
            paymentGenerated.get().setQrCode(qrCode.get().getPointOfInteraction().getTransactionData().getQrCode());

        }

        return paymentGenerated;
    }
}
