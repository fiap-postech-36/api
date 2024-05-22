package br.com.nomeempresa.restaurante.ports.in;


import br.com.nomeempresa.restaurante.core.domain.Payment;

public interface IPaymentServicePort {

    Payment generatedPayment(Payment payment);
    Payment updatePayment(Payment payment);
    Payment getPayment(Long id);
    String getStatusPayment(Long id);

}
