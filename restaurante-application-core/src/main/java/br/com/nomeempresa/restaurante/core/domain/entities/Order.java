package br.com.nomeempresa.restaurante.core.domain.entities;


import br.com.nomeempresa.restaurante.core.exception.CoreExceptionRuntime;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order implements Serializable {

    private Long id;
    private OrderStatus status;
    private LocalDateTime receivedAt;
    private LocalDateTime finishedAt;
    private List<Product> products;

    public Order(Long id, OrderStatus status, LocalDateTime receivedAt, LocalDateTime finishedAt, List<Product> products) {
        this.id = id;
        this.status = status;
        this.receivedAt = receivedAt;
        this.finishedAt = finishedAt;
        this.products = products;
    }

    public void addItem(final Product produto) {
        if (Objects.nonNull(products)) {
            this.products.add(produto);
        }
    }

    public void sendToKitchen() {
        if (OrderStatus.CREATED != this.status) {
            throw new CoreExceptionRuntime("Status do pedido inválido");
        }

        this.status = this.status.getNext();
        this.receivedAt = LocalDateTime.now();
    }
    public BigDecimal calculateTotal() {
        return this.products.stream()
            .map(Product::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public Long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

}