package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.ports.in.IPaymentServicePort;
import br.com.nomeempresa.restaurante.ports.out.IPaymentPort;

import java.util.List;

public class PaymentService implements IPaymentServicePort {


    private final IPaymentPort iPaymentPort;

    public PaymentService(IPaymentPort iPaymentPort) {
        this.iPaymentPort = iPaymentPort;
    }

    @Override
    public Payment generatedPayment(Payment request) {
        return iPaymentPort.generatedPayment(request);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return iPaymentPort.updatePayment(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return iPaymentPort.getPayment(id);
    }

    @Override
    public StatusPayment getStatusPayment(Long id) {
        return iPaymentPort.getStatusPayment(id);
    }

    @Override
    public List<Payment> getListPayments() {
        return iPaymentPort.getListPayments();
    }
}
