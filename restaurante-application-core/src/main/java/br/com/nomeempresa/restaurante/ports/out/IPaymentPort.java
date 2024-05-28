package br.com.nomeempresa.restaurante.ports.out;

import br.com.nomeempresa.restaurante.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;

import java.math.BigDecimal;
import java.util.List;

public interface IPaymentPort {


    Payment save(final Payment payment);

    Payment generatedPayment(Payment payment);
    Payment updatePayment(Payment payment);
    Payment getPayment(Long id);
    StatusPayment getStatusPayment(Long id);
    List<Payment> getListPayments();
    StatusPayment checkout(final Order order);

}
