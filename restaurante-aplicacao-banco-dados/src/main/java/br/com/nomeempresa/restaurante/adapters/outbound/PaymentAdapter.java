package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.PaymentEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.OrderMapper;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.PaymentMapper;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.OrderRepository;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.PaymentRepository;
import br.com.nomeempresa.restaurante.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.ports.out.IPaymentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class PaymentAdapter implements IPaymentPort {

    private final PaymentRepository paymentRepository;
    private static final List<Payment> payments = new ArrayList<>();


    @Override
    @Transactional
    public Payment save(Payment payment) {
        final var paymentEntity = paymentRepository.save(PaymentMapper.INSTANCE.paymentToPaymentEntity(payment));
        return PaymentMapper.INSTANCE.paymentEntityToPayment(paymentEntity);
    }

    @Override
    public Payment generatedPayment(Payment payment) {
        Payment paymentDTO = new Payment(payment.getAmount(), payment.getClient(), payment.getOrder(), payment.getStatus());

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

    @Override
    public StatusPayment checkout(final Order order) {
        try {
            Thread.sleep(2000);
            return StatusPayment.PAID;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Payment recoverDataPayment(Long id) {

        return payments.stream()
                .filter(payment -> payment.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Payment not found with id: " + id));

    }

}
