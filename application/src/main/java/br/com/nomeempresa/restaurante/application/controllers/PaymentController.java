package br.com.nomeempresa.restaurante.application.controllers;

import br.com.nomeempresa.restaurante.application.facade.PaymentFacade;
import br.com.nomeempresa.restaurante.application.inout.input.FilterInput;import br.com.nomeempresa.restaurante.application.inout.input.PaymentInput;
import br.com.nomeempresa.restaurante.application.inout.input.PaymentUpdateInput;
import br.com.nomeempresa.restaurante.application.inout.output.PaymentOutput;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.StatusPayment;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentFacade paymentFacade;

    @PostMapping
    public ResponseEntity<PaymentOutput> generatePayment(@RequestBody @Valid PaymentInput request) {
        return ResponseEntity.ok(paymentFacade.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentOutput> getPayment(@PathVariable Long id) {
        return ResponseEntity.ok(paymentFacade.get(id));
    }

    @PutMapping("/proces/payments")
    public ResponseEntity<PaymentOutput> updatePayment(@RequestBody @Valid PaymentUpdateInput request) {
        return ResponseEntity.ok(paymentFacade.updatePayment(request));
    }

    @GetMapping
    public ResponseEntity<Page<PaymentOutput>> getListPayments(final Map<String, String> filter) {
        return ResponseEntity.ok(paymentFacade.filter(new FilterInput(filter)));
    }

    @PostMapping("/checkout/{idOrder}")
    public ResponseEntity<StatusPayment> checkout(final @PathVariable Long idOrder) {
        return ResponseEntity.ok().body(paymentFacade.checkout(idOrder));
    }

}
