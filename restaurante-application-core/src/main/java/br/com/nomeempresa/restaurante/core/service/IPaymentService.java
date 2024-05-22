package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.Payment;
import br.com.nomeempresa.restaurante.ports.in.IPaymentServicePort;

public class IPaymentService implements IPaymentServicePort {

    private static Payment paymentActive;

    @Override
    public Payment generatedPayment(Payment request) {
        return paymentActive = new Payment(request.getAmount(), request.getClient(), request.getDate(), request.getProduct(), request.getStatus());
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return this.recoverDataPayment(payment.getId());
    }

    @Override
    public Payment getPayment(Long id) {
        return this.recoverDataPayment(id);
    }

    @Override
    public String getStatusPayment(Long id) {
        return recoverDataPayment(id).getStatus();
    }

    private Payment recoverDataPayment(Long id) {
        Payment paymentResponse = paymentActive;

        if (paymentResponse == null) {
            throw new IllegalArgumentException();
        }

        return paymentResponse;
    }
}
