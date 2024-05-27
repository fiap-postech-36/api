package br.com.nomeempresa.restaurante.adapters.inbound.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Table(name = "order_item")
@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "product_id")
    private ProdutoEntity product;

    @Column(name = "order_id")
    private OrderEntity order;
}
