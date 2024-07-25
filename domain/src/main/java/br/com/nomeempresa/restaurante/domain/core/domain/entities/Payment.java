package br.com.nomeempresa.restaurante.domain.core.domain.entities;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@Setter
public class Payment  implements Serializable {

    private Long id;
    private BigDecimal amount;
    private String client;
    private StatusPayment status;
    private String qrCode;
    private Order order;
    private LocalDateTime date;

}
