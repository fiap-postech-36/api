package br.com.nomeempresa.restaurante.ports.out;


import br.com.nomeempresa.restaurante.core.domain.Order;
import br.com.nomeempresa.restaurante.core.domain.OrderStatus;

import java.util.Collection;

public interface OrderPort {


    Order edit(final Order order);

    Order create(final Order order);

    void remove(final Long id);

    Order findById(final Long id);

    Collection<Order> findByStatus(final OrderStatus status);

    Collection<Order> findAll();
}
