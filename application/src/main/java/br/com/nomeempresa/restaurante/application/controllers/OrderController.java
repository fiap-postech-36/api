package br.com.nomeempresa.restaurante.application.controllers;

import br.com.nomeempresa.restaurante.application.inout.input.OrderInput;
import br.com.nomeempresa.restaurante.application.inout.mapper.OrderInputOutputMapper;
import br.com.nomeempresa.restaurante.domain.gateway.OrderGateway;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.OrderStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderGateway orderGateway;

    @GetMapping
    public ResponseEntity<Collection<Order>> findAll() {
        return ResponseEntity.ok().body(orderGateway.findAll());
    }

    @GetMapping("/filter")
    public ResponseEntity<Collection<Order>> filter(@RequestParam(required = false) final OrderStatus status) {
        return ResponseEntity.ok().body(orderGateway.findByStatus(status));
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody @Valid final OrderInput orderInput) {
        return ResponseEntity.ok().body(orderGateway.save(OrderInputOutputMapper.INSTANCE.orderEntityToOrder()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable final Long id) {
        orderGateway.remove(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(orderGateway.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> edit(@PathVariable final Long id, @RequestBody OrderInput orderInput) {
        final var order = orderGateway.edit(id, orderInput.products());
        return ResponseEntity.ok().body(order);
    }

}

