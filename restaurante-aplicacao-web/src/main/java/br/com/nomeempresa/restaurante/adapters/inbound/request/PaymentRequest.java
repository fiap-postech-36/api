package br.com.nomeempresa.restaurante.adapters.inbound.request;

import br.com.nomeempresa.restaurante.core.domain.StatusPayment;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PaymentRequest(

        @NotNull(message = "amount must be provided")
        @DecimalMin(message = "minimum value for amount is zero", value = "1.0", inclusive = true)
        BigDecimal amount,

        String client,

        @NotNull(message = "status must be provided")
        StatusPayment status,

        @NotNull(message = "product must be provided")
        String product
){}
