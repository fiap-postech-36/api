package br.com.nomeempresa.restaurante.core.domain;

public enum OrderStatus {

    CREATED("Criado", 0),
    RECEIVED("Recebido", 1),
    IN_PREPARATION("Em preparação", 2),
    READY("Pronto", 3),
    FINISHED("Finalizado", 4);

    private final String description;

    private final int order;
    OrderStatus(final String description, final int order) {
        this.description = description;
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public int getOrder() {
        return order;
    }


    public static OrderStatus getFromOrder(final int order) {
        for (OrderStatus status : OrderStatus.values()) {
            if (order == status.getOrder()) {
                return status;
            }
        }
        return null;
    }

    public OrderStatus getNext() {
        return getFromOrder(this.getOrder() + 1);
    }
}
