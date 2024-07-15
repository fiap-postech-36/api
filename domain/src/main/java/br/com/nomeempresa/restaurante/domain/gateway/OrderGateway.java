package br.com.nomeempresa.restaurante.domain.gateway;


import br.com.nomeempresa.restaurante.domain.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.OrderStatus;

import java.util.Collection;
import java.util.List;

public interface OrderGateway {

    Order create(final List<Long> productsId);

    Order save(final Order order);

    Order edit(final Long id, final List<Long> productsId);

    void remove(final Long id);

    Order findById(final Long id);

    Collection<Order> findByStatus(final OrderStatus status);

    Collection<Order> findAll();
}
