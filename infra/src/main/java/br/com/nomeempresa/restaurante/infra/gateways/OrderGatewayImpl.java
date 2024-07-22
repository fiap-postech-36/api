package br.com.nomeempresa.restaurante.infra.gateways;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.OrderStatus;
import br.com.nomeempresa.restaurante.domain.gateway.OrderGateway;
import br.com.nomeempresa.restaurante.infra.mapper.OrderMapper;
import br.com.nomeempresa.restaurante.infra.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderGatewayImpl implements OrderGateway {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper = OrderMapper.INSTANCE;

    @Override
    public Optional<Order> save(final Order order) {
        final var orderEntity = mapper.orderToOrderEntity(order);
        return Optional.ofNullable(mapper.orderEntityToOrder(orderRepository.save(orderEntity)));
    }

    @Override
    public Optional<Order> update(final Order order) {
        return Optional.empty();
    }

    @Override
    public void remove(final Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> findById(final Long id) {
        return Optional.ofNullable(mapper.orderEntityToOrder(orderRepository.findById(id).orElse(null)));
    }

    @Override
    public Collection<Order> findByStatus(final OrderStatus status) {
        return orderRepository.findByStatus(status).stream()
            .map(mapper::orderEntityToOrder)
            .toList();
    }

    @Override
    public Collection<Order> findAll() {
        return orderRepository.findAll().stream()
            .map(mapper::orderEntityToOrder)
            .toList();
    }

    @Override
    public Collection<Order> filter(OrderStatus status) {
        return findByStatus(status);
    }
}
