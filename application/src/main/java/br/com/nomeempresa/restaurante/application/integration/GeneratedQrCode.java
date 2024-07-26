package br.com.nomeempresa.restaurante.application.integration;

import br.com.nomeempresa.restaurante.application.gateway.IntegrationLinkPaymentGateway;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.QrCode;
import br.com.nomeempresa.restaurante.infra.feign.client.MercadoPagoQrCodeClient;
import br.com.nomeempresa.restaurante.infra.feign.presenter.request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GeneratedQrCode implements IntegrationLinkPaymentGateway {

    private final MercadoPagoQrCodeClient client;

    @Override
    public Optional<QrCode> generatedQrCode(PaymentRequest request) {
        return Optional.ofNullable(client.generatedQrCode(request));
    }
}
