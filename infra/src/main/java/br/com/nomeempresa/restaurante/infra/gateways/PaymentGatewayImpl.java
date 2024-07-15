package br.com.nomeempresa.restaurante.infra.gateways;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.domain.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentGatewayImpl implements PaymentGateway {
    @Override
    public Payment generatedPayment(Payment payment) {
        return null;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return null;
    }

    @Override
    public Payment getPayment(Long id) {
        return null;
    }

    @Override
    public StatusPayment getStatusPayment(Long id) {
        return null;
    }

    @Override
    public List<Payment> getListPayments() {
        return null;
    }

    @Override
    public StatusPayment checkout(Long idOrder) {
        return null;
    }
}
