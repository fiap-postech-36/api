package br.com.nomeempresa.restaurante.infra.feign.integration;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.QrCode;
import br.com.nomeempresa.restaurante.domain.gateway.IntegrationLinkPaymentGateway;
import br.com.nomeempresa.restaurante.infra.feign.client.MercadoPagoQrCodeClient;
import br.com.nomeempresa.restaurante.infra.mapper.GeneratedQrCodeMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GeneratedQrCode implements IntegrationLinkPaymentGateway {

    private final MercadoPagoQrCodeClient client;

    public GeneratedQrCode(MercadoPagoQrCodeClient client) {
        this.client = client;
    }

    @Override
    public Optional<QrCode> generatedQrCode(Payment payment) {
        return Optional.ofNullable(client.generatedQrCode(GeneratedQrCodeMapper.INTANCE.paymentToPaymentRequest(payment)));
    }
}
