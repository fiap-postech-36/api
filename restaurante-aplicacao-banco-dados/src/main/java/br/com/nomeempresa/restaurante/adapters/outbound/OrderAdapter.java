package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.OrderEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProdutoEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.OrderMapper;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.OrderRepository;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.ProdutoRepository;
import br.com.nomeempresa.restaurante.core.domain.Order;
import br.com.nomeempresa.restaurante.core.domain.OrderStatus;
import br.com.nomeempresa.restaurante.ports.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderPort {

    private final OrderRepository orderRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    @Transactional
    public Order edit(final Long id, final List<Long> productsId) {
        final var orderEntity = orderRepository.findById(id)
            .orElseThrow();

        List<ProdutoEntity> products = produtoRepository.findByIdIn(productsId);

        orderEntity.getProducts().removeIf(item -> !productsId.contains(item.getId()));

        orderEntity.getProducts().addAll(products);

        orderRepository.save(orderEntity);

        return OrderMapper.INSTANCE.orderEntityToOrder(orderEntity);
    }

    @Override
    @Transactional
    public Order create(final List<Long> productsId) {
        List<ProdutoEntity> products = produtoRepository.findByIdIn(productsId);
        final var orderEntity = new OrderEntity(null, OrderStatus.CREATED, LocalDateTime.now(), null, products);
        final var orderSaved = orderRepository.save(orderEntity);

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
