package br.com.nomeempresa.restaurante.domain.core.domain.entities;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode
@AllArgsConstructor
public class Payment  implements Serializable {

    private Long id;
    private BigDecimal amount;
    private String client;
    private StatusPayment status;
    private String qrCode;
    private Order order;
    private LocalDateTime date;

    public Payment(Long id, BigDecimal amount, String client, LocalDateTime date, Order order, String qrCode, StatusPayment status) {
        this.id = id;
        this.amount = amount;
        this.client = client;
        this.date = LocalDateTime.now();
        this.order = order;
        this.qrCode = qrCode;
        this.status = status;
    }

    public void setStatusPending() {
        this.status = StatusPayment.PENDING;
    }

    public void setStatusPaid() {
        this.status = StatusPayment.PAID;
    }

    public void setStatusReject() {
        this.status = StatusPayment.REJECT;
    }

    public Order getOrder() {
        return order;
    }

    public StatusPayment getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
