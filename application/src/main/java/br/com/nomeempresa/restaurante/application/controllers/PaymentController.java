package br.com.nomeempresa.restaurante.application.controllers;

import br.com.nomeempresa.restaurante.application.exception.ResourceNotFound;
import br.com.nomeempresa.restaurante.application.inout.mapper.PaymentInputOutputMapper;
import br.com.nomeempresa.restaurante.application.inout.input.PaymentInput;
import br.com.nomeempresa.restaurante.domain.gateway.PaymentGateway;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.StatusPayment;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentGateway paymentGateway;


    @PostMapping
    public Payment generatePayment(@RequestBody @Valid PaymentInput request) {
        return paymentGateway.generatedPayment(PaymentInputOutputMapper.INSTANCE.paymentRequestToPayment(request))
            .orElseThrow(ResourceNotFound::new);
    }

    @PutMapping
    public Payment updatePayment(@RequestBody PaymentInput request) {
        return paymentGateway.updatePayment(PaymentInputOutputMapper.INSTANCE.paymentRequestToPayment(request))
            .orElseThrow(ResourceNotFound::new);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return paymentGateway.getPayment(id).orElseThrow(ResourceNotFound::new);
    }

    @GetMapping
    public Collection<Payment> getListPayments() {
        return paymentGateway.getListPayments();
    }

    @PostMapping("/checkout/{idOrder}")
    public ResponseEntity<StatusPayment> checkout(final @PathVariable Long idOrder) {
        return ResponseEntity.ok().body(paymentGateway.checkout(idOrder).orElseThrow(ResourceNotFound::new));
    }

}
