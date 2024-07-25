package br.com.nomeempresa.restaurante.infra.feign.presenter.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    @JsonProperty("description")
    private String description;

    @JsonProperty("transaction_amount")
    private Double transactionAmount;

    @JsonProperty("payment_method_id")
    private String paymentMethodId;

}
