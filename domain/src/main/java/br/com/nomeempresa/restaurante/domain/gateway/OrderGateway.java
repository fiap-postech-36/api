package br.com.nomeempresa.restaurante.domain.gateway;


import br.com.nomeempresa.restaurante.domain.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.OrderStatus;

import java.util.Collection;
import java.util.Optional;

public interface OrderGateway {

    Optional<Order> save(final Order order);

    Optional<Order> update(final Order order);

    void remove(final Long id);

    Optional<Order> findById(final Long id);

    Collection<Order> findByStatus(final String status);

    Collection<Order> findAll();

    Collection<Order> filter(final String status);
}
