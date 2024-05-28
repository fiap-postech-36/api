package br.com.nomeempresa.restaurante.adapters.inbound.entity;

import br.com.nomeempresa.restaurante.core.domain.entities.StatusPayment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "PAYMENT")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "client")
    private String client;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPayment status;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(name = "paymentAt", nullable = false)
    private LocalDateTime date;

}
