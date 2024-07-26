package br.com.nomeempresa.restaurante.infra.feign.presenter.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentRequest {

    @JsonProperty("description")
    private String description;

    @JsonProperty("transaction_amount")
    private BigDecimal transactionAmount;

    @JsonProperty("payment_method_id")
    private String paymentMethodId;

}
