package br.com.nomeempresa.restaurante.infra.gateways;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.OrderStatus;
import br.com.nomeempresa.restaurante.domain.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderGatewayImpl implements OrderGateway {
    @Override
    public Order create(List<Long> productsId) {
        return null;
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Order edit(Long id, List<Long> productsId) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public Collection<Order> findByStatus(OrderStatus status) {
        return null;
    }

    @Override
    public Collection<Order> findAll() {
        return null;
    }
}
