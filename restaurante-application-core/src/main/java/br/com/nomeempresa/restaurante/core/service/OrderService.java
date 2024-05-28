package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.core.domain.entities.OrderStatus;
import br.com.nomeempresa.restaurante.core.exception.CoreExceptionRuntime;
import br.com.nomeempresa.restaurante.ports.in.OrderServicePort;
import br.com.nomeempresa.restaurante.ports.out.OrderPort;

import java.beans.Transient;
import java.util.Collection;
import java.util.List;

public class OrderService implements OrderServicePort {

    private final OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @Override
    public Order create(final List<Long> productsId) {
        if (productsId.isEmpty()) {
            throw new CoreExceptionRuntime("É necessário incluir itens no pedido");
        }
        return orderPort.create(productsId);
    }

    @Override
    public Order save(Order order) {
        return orderPort.save(order);
    }

    @Override
    public Order edit(final Long id, final List<Long> productsId) {
        return orderPort.edit(id, productsId);
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
