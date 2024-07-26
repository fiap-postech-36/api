package br.com.nomeempresa.restaurante.application.inout.input;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.StatusPayment;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PaymentUpdateInput(

        Order order,
        StatusPayment status

){}
