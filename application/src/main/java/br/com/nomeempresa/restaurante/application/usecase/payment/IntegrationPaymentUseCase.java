package br.com.nomeempresa.restaurante.application.usecase.payment;

import br.com.nomeempresa.restaurante.application.inout.input.PaymentInput;
import br.com.nomeempresa.restaurante.application.inout.mapper.PaymentInputOutputMapper;
import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.QrCode;
import br.com.nomeempresa.restaurante.domain.gateway.IntegrationLinkPaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IntegrationPaymentUseCase implements UseCase<PaymentInput, QrCode> {

    private final IntegrationLinkPaymentGateway gateway;

    public IntegrationPaymentUseCase(IntegrationLinkPaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Optional<QrCode> execute(PaymentInput paymentInput) {
        return gateway.generatedQrCode(PaymentInputOutputMapper.INSTANCE.paymentRequestToPayment(paymentInput));
    }
}
