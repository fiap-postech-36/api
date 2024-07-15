package br.com.nomeempresa.restaurante.domain.gateway;


import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.StatusPayment;

import java.util.List;

public interface PaymentGateway {

    Payment generatedPayment(Payment payment);
    Payment updatePayment(Payment payment);
    Payment getPayment(Long id);
    StatusPayment getStatusPayment(Long id);
    List<Payment> getListPayments();
    StatusPayment checkout(final Long idOrder);

}
