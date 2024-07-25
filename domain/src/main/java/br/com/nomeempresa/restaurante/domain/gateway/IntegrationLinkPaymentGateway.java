package br.com.nomeempresa.restaurante.domain.gateway;


import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.QrCode;

import java.util.Optional;

public interface IntegrationLinkPaymentGateway {

    Optional<QrCode> generatedQrCode(Payment payment);

}
