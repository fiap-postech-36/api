package br.com.nomeempresa.restaurante.infra.gateways;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.gateway.PaymentGateway;
import br.com.nomeempresa.restaurante.infra.entity.OrderEntity;
import br.com.nomeempresa.restaurante.infra.entity.PaymentEntity;
import br.com.nomeempresa.restaurante.infra.mapper.PaymentMapper;
import br.com.nomeempresa.restaurante.infra.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentGatewayImpl implements PaymentGateway {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper mapper = PaymentMapper.INSTANCE;

    @Override
    public Optional<Payment> save(final Payment payment) {
        final var paymentEntity = mapper.paymentToPaymentEntity(payment);
        return Optional.ofNullable(mapper.paymentEntityToPayment(paymentRepository.save(paymentEntity)));
    }

    @Override
    public Optional<Payment> update(final Payment newPayment) {
        OrderEntity order = new OrderEntity();
        order.setId(newPayment.getOrder().getId());

        PaymentEntity payment = this.paymentRepository.findByOrder(order);
        payment.setStatus(newPayment.getStatus());
        return Optional.ofNullable(mapper.paymentEntityToPayment(paymentRepository.save(payment)));
    }

    @Override
    public Optional<Payment> findById(final Long id) {
        return Optional.ofNullable(mapper.paymentEntityToPayment(paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"))));
    }

    @Override
    public Collection<Payment> findAll() {
        return paymentRepository.findAll().stream()
            .map(mapper::paymentEntityToPayment)
            .toList();
    }

}
