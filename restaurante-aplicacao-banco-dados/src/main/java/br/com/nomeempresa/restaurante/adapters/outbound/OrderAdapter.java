package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.OrderItemEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProdutoEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorProdutoDominioEntidade;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.OrderMapper;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.OrderRepository;
import br.com.nomeempresa.restaurante.core.domain.Order;
import br.com.nomeempresa.restaurante.core.domain.OrderStatus;
import br.com.nomeempresa.restaurante.core.domain.entities.Produto;
import br.com.nomeempresa.restaurante.ports.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderPort {

    private final ConversorProdutoDominioEntidade conversorProduto;
    private final OrderRepository orderRepository;

    @Override
    public Order edit(Order order) {
        final var orderEntity = orderRepository.findById(order.getId())
            .orElseThrow();

        List<Long> idsItems = order.getItems().stream()
            .map(Produto::getId)
            .collect(Collectors.toList());

        orderEntity.getItems().removeIf(item -> !idsItems.contains(item.getProduct().getId()));

        orderRepository.save(orderEntity);

        return OrderMapper.INSTANCE.orderEntityToOrder(orderEntity);
    }

    @Override
    public Order create(Order order) {
        final var orderEntity = OrderMapper.INSTANCE.orderToOrderEntity(order);
        final List<OrderItemEntity> items = order.getItems()
            .stream()
            .map(produto ->
                new OrderItemEntity(null, conversorProduto.converterParaEntidade(produto), orderEntity)
            )
            .collect(Collectors.toList());

        orderEntity.setItems(items);

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
