package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.OrderEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProductEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.OrderMapper;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.OrderRepository;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.ProductRepository;
import br.com.nomeempresa.restaurante.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.core.domain.entities.OrderStatus;
import br.com.nomeempresa.restaurante.core.exception.CoreExceptionRuntime;
import br.com.nomeempresa.restaurante.ports.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderPort {

    private final OrderRepository orderRepository;
    private final ProductRepository produtoRepository;

    @Override
    @Transactional
    public Order edit(final Long id, final List<Long> productsId) {
        final var orderEntity = orderRepository.findById(id)
            .orElseThrow();

        if (Objects.isNull(productsId)) {
            throw new CoreExceptionRuntime("Lista de produtos não pode ser nula");
        }

        if (productsId.isEmpty()) {
            orderEntity.setProducts(null);
            orderRepository.save(orderEntity);
            return OrderMapper.INSTANCE.orderEntityToOrder(orderEntity);
        }

        List<ProductEntity> products = produtoRepository.findByIdIn(productsId);

        orderEntity.getProducts().removeIf(item -> !productsId.contains(item.getId()));

        orderEntity.getProducts().addAll(products);

        orderRepository.save(orderEntity);

        return OrderMapper.INSTANCE.orderEntityToOrder(orderEntity);
    }

    @Override
    @Transactional
    public Order save(Order order) {
        final var orderEntity = orderRepository.save(OrderMapper.INSTANCE.orderToOrderEntity(order));
        return OrderMapper.INSTANCE.orderEntityToOrder(orderEntity);
    }

    @Override
    @Transactional
    public Order create(final List<Long> productsId) {
        List<ProductEntity> products = produtoRepository.findByIdIn(productsId);
        final var orderEntity = new OrderEntity(null, OrderStatus.CREATED, null, null, products);
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
        List<Order> orders = orderRepository.findByStatus(status).stream()
            .map(OrderMapper.INSTANCE::orderEntityToOrder)
            .collect(Collectors.toList());

        orders.sort(Comparator.comparing(Order::getReceivedAt).reversed());

       return orders;
    }

    @Override
    public Collection<Order> findAll() {
        return orderRepository.findAll().stream()
            .map(OrderMapper.INSTANCE::orderEntityToOrder)
            .collect(Collectors.toList());
    }
}
