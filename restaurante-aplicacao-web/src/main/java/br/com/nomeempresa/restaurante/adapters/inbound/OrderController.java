package br.com.nomeempresa.restaurante.adapters.inbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.OrderRequestMapper;
import br.com.nomeempresa.restaurante.adapters.inbound.request.OrderRequest;
import br.com.nomeempresa.restaurante.core.domain.Order;
import br.com.nomeempresa.restaurante.core.domain.OrderStatus;
import br.com.nomeempresa.restaurante.ports.in.OrderServicePort;
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
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServicePort orderServicePort;

    @GetMapping
    public ResponseEntity<Collection<Order>> filter(@RequestParam(required = false) final OrderStatus status) {
        if (Objects.isNull(status)) {
            return ResponseEntity.ok().body(orderServicePort.findAll());
        }
        return ResponseEntity.ok().body(orderServicePort.findByStatus(status));
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody @Valid final OrderRequest orderRequest) {
        return ResponseEntity.ok().body(orderServicePort.create(OrderRequestMapper.INSTANCE.orderRequestToOrder(orderRequest)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable final Long id) {
        orderServicePort.remove(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(orderServicePort.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> edit(@PathVariable final Long id, @RequestBody OrderRequest orderRequest) {
        final var orderReqWithId = new OrderRequest(id, orderRequest.items());
        final var order = OrderRequestMapper.INSTANCE.orderRequestToOrder(orderReqWithId);

        return ResponseEntity.ok().body(orderServicePort.edit(order));
    }

}

