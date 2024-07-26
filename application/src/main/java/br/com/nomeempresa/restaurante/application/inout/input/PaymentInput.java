package br.com.nomeempresa.restaurante.application.inout.input;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.StatusPayment;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PaymentInput(

        @NotNull(message = "amount must be provided")
        @DecimalMin(message = "minimum value for amount is zero", value = "1.0", inclusive = true)
        BigDecimal amount,

        String client,

        String method,

        String descripton,

        @NotNull(message = "order must be provided")
        Long order
){}
