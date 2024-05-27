package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.OrderMapper;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.OrderRepository;
import br.com.nomeempresa.restaurante.core.domain.Order;
import br.com.nomeempresa.restaurante.core.domain.OrderStatus;
import br.com.nomeempresa.restaurante.ports.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderPort {

    private final OrderRepository orderRepository;
    @Override
    public Order save(Order order) {
        final var orderSaved = orderRepository.save(OrderMapper.INSTANCE.orderToOrderEntity(order));
        return OrderMapper.INSTANCE.orderEntityToOrder(orderSaved);
    }

    @Override
    public void remove(Long id) {
        final var orderToRemove = orderRepository.findById(id)
            .orElseThrow();
        orderRepository.delete(orderToRemove);
    }

    @Override
    public Order findById(Long id) {
        return OrderMapper.INSTANCE.orderEntityToOrder(orderRepository.findById(id)
            .orElseThrow());
    }

    @Override
    public Collection<Order> findByStatus(OrderStatus status) {
       return orderRepository.findByStatus(status).stream()
            .map(OrderMapper.INSTANCE::orderEntityToOrder)
            .collect(Collectors.toList());
    }

    @Override
    public Collection<Order> findAll() {
        return orderRepository.findAll().stream()
            .map(OrderMapper.INSTANCE::orderEntityToOrder)
            .collect(Collectors.toList());
    }
}
