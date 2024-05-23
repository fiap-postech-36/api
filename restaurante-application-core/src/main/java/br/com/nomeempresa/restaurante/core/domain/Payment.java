package br.com.nomeempresa.restaurante.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

public class Payment  implements Serializable {

    private Long id;
    private BigDecimal amount;
    private String client;
    private StatusPayment status;
    private String product;
    private LocalDateTime date;

    public Payment() {}

    public Payment(BigDecimal amount, String client, String product, StatusPayment status) {
        Random random = new Random();
        this.id = (long) random.nextInt(100);
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.client = client;
        this.product = product;
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getClient() {
        return client;
    }

    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public StatusPayment getStatus() {
        return status;
    }

    public void setStatus(StatusPayment status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
