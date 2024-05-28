package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.ports.in.IPaymentServicePort;
import br.com.nomeempresa.restaurante.ports.in.OrderServicePort;
import br.com.nomeempresa.restaurante.ports.out.IPaymentPort;

import java.beans.Transient;
import java.util.List;

public class PaymentService implements IPaymentServicePort {


    private final IPaymentPort iPaymentPort;

    private final OrderServicePort orderServicePort;

    public PaymentService(final IPaymentPort iPaymentPort, final OrderServicePort orderServicePort) {
        this.iPaymentPort = iPaymentPort;
        this.orderServicePort = orderServicePort;
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

    @Override
    public StatusPayment checkout(final Long idOrder) {
        final var order = orderServicePort.findById(idOrder);
        final var paymentStatus = iPaymentPort.checkout(order);

        if (StatusPayment.PAID == paymentStatus) {
            order.sendToKitchen();
            orderServicePort.save(order);
            final var payment = new Payment(order.calculateTotal(), null, order, paymentStatus);
            iPaymentPort.save(payment);
        }
        return paymentStatus;
    }
}
