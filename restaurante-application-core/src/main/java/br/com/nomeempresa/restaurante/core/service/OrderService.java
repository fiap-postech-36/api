package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.Order;
import br.com.nomeempresa.restaurante.core.domain.OrderStatus;
import br.com.nomeempresa.restaurante.ports.in.OrderServicePort;
import br.com.nomeempresa.restaurante.ports.out.OrderPort;

import java.util.Collection;

public class OrderService implements OrderServicePort {

    private final OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @Override
    public Order create(Order order) {
        return orderPort.create(order);
    }

    @Override
    public Order edit(Order order) {
        final var orderDb = orderPort.findById(order.getId());
        orderDb.setItems(order.getItems());
        orderPort.create(orderDb);
        return orderDb;
    }

    @Override
    public void remove(Long id) {
        orderPort.remove(id);
    }

    @Override
    public Order findById(Long id) {
        return orderPort.findById(id);
    }

    @Override
    public Collection<Order> findByStatus(OrderStatus status) {
        return orderPort.findByStatus(status);
    }

    @Override
    public Collection<Order> findAll() {
        return orderPort.findAll();
    }
}
