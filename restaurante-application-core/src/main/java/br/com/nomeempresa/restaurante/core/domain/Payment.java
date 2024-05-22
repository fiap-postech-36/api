package br.com.nomeempresa.restaurante.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class Payment  implements Serializable {

    private Long id;
    private BigDecimal amount;
    private String client;
    private String status;
    private String product;
    private LocalDate date;

    public Payment() {}

    public Payment(BigDecimal amount, String client, LocalDate date, String product, String status) {
        this.id = new Random().nextLong();
        this.amount = amount;
        this.client = client;
        this.date = date;
        this.product = product;
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
