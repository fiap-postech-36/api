package br.com.nomeempresa.restaurante.infra.gateways;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.StatusPayment;
import br.com.nomeempresa.restaurante.domain.gateway.PaymentGateway;
import br.com.nomeempresa.restaurante.infra.mapper.PaymentMapper;
import br.com.nomeempresa.restaurante.infra.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
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
    public Optional<Payment> update(final Payment payment) {
        return save(payment);
    }

    @Override
    public Optional<Payment> findById(final Long id) {
        return Optional.ofNullable(mapper.paymentEntityToPayment(paymentRepository.findById(id).orElse(null)));
    }

    @Override
    public Collection<Payment> findAll() {
        return paymentRepository.findAll().stream()
            .map(mapper::paymentEntityToPayment)
            .toList();
    }

}
