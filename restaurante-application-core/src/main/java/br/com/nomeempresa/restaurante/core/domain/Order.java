package br.com.nomeempresa.restaurante.core.domain;


import br.com.nomeempresa.restaurante.core.domain.entities.Produto;
import br.com.nomeempresa.restaurante.core.exception.CoreExceptionRuntime;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order {

    private Long id;
    private OrderStatus status = OrderStatus.CREATED;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private List<Produto> items;

    public Order(Long id, OrderStatus status, LocalDateTime createdAt, LocalDateTime finishedAt, List<Produto> items) {
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.items = items;
    }

    public void addItem(final Produto produto) {
        if (Objects.nonNull(items)) {
            this.items.add(produto);
        }
    }

    public void nextStatus() {
        final var nextStatus = this.status.getNext();

        if (Objects.isNull(nextStatus)) {
            throw new CoreExceptionRuntime("Pedido já foi finalizado");
        }

        this.status = nextStatus;
    }
    public BigDecimal calculateTotal() {
        return this.items.stream()
            .map(Produto::getPreco)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public Long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setItems(List<Produto> items) {
        this.items = items;
    }

    public List<Produto> getItems() {
        return items;
    }

}