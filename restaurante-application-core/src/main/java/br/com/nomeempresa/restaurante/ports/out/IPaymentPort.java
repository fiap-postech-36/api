package br.com.nomeempresa.restaurante.ports.out;

import br.com.nomeempresa.restaurante.core.domain.Payment;

import java.util.List;

public interface IPaymentPort {

    Payment generatedPayment(Payment payment);
    Payment updatePayment(Payment payment);
    Payment getPayment(Long id);
    String getStatusPayment(Long id);
    List<Payment> getListPayments();
}
