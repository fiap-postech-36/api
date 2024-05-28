package br.com.nomeempresa.restaurante.ports.out;


import br.com.nomeempresa.restaurante.core.domain.Order;
import br.com.nomeempresa.restaurante.core.domain.OrderStatus;

import java.util.Collection;
import java.util.List;

public interface OrderPort {


    Order edit(final Long id, final List<Long> products);

    Order create(final List<Long> products);

    void remove(final Long id);

    Order findById(final Long id);

    Collection<Order> findByStatus(final OrderStatus status);

    Collection<Order> findAll();
}
