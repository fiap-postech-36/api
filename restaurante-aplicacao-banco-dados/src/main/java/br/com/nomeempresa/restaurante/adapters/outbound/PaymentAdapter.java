package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.outbound.repository.PaymentRepository;
import br.com.nomeempresa.restaurante.core.domain.Payment;
import br.com.nomeempresa.restaurante.core.domain.StatusPayment;
import br.com.nomeempresa.restaurante.ports.out.IPaymentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class PaymentAdapter implements IPaymentPort {

    private final PaymentRepository paymentRepository;

    private static final List<Payment> payments = new ArrayList<>();


    @Override
    public Payment generatedPayment(Payment payment) {
        Payment paymentDTO = new Payment(payment.getAmount(), payment.getClient(), payment.getProduct(), payment.getStatus());

        payments.add(paymentDTO);

        return paymentDTO;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return recoverDataPayment(payment.getId());
    }

    @Override
    public Payment getPayment(Long id) {
        return recoverDataPayment(id);
    }

    @Override
    public StatusPayment getStatusPayment(Long id) {
        return recoverDataPayment(id).getStatus();
    }

    @Override
    public List<Payment> getListPayments() {
        return payments;
    }

    private Payment recoverDataPayment(Long id) {

        return payments.stream()
                .filter(payment -> payment.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Payment not found with id: " + id));

    }
}
