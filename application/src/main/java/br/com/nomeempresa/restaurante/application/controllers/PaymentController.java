package br.com.nomeempresa.restaurante.application.controllers;

import br.com.nomeempresa.restaurante.application.inout.mapper.PaymentRequestResponseMapper;
import br.com.nomeempresa.restaurante.application.inout.input.PaymentInput;
import br.com.nomeempresa.restaurante.domain.gateway.PaymentGateway;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.StatusPayment;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentGateway paymentGateway;


    @PostMapping("generate-payment")
    public Payment generatePayment(@RequestBody @Valid PaymentInput request) {
        return paymentGateway.generatedPayment(PaymentRequestResponseMapper.INSTANCE.paymentRequestToPayment(request));
    }

    @PutMapping
    public Payment updatePayment(@RequestBody PaymentInput request) {
        return paymentGateway.updatePayment(PaymentRequestResponseMapper.INSTANCE.paymentRequestToPayment(request));
    }

    @GetMapping("findById/{id}")
    public Payment getPayment(@PathVariable(name = "id",required = false) Long id) {
        return paymentGateway.getPayment(id);
    }

    @GetMapping("list-payments")
    public List<Payment> getListPayments() {
        return paymentGateway.getListPayments();
    }

    @GetMapping("status/{id}")
    public StatusPayment getStatusPayment(@PathVariable(name = "id",required = false) Long id) {
        return paymentGateway.getStatusPayment(id);
    }

    @PostMapping("/checkout/{idOrder}")
    public ResponseEntity<StatusPayment> checkout(final @PathVariable Long idOrder) {
        return ResponseEntity.ok().body(paymentGateway.checkout(idOrder));
    }

}
