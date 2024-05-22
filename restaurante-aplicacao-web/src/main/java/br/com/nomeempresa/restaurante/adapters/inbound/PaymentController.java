package br.com.nomeempresa.restaurante.adapters.inbound;

import br.com.nomeempresa.restaurante.core.domain.Payment;
import br.com.nomeempresa.restaurante.ports.in.IPaymentServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final IPaymentServicePort iPaymentServicePort;

    @PostMapping
    public Payment generatePayment(@RequestBody Payment payment) {
        return iPaymentServicePort.generatedPayment(payment);
    }

    @PutMapping
    public Payment updatePayment(@RequestBody Payment payment) {
        return iPaymentServicePort.updatePayment(payment);
    }

    @GetMapping
    public Payment getPayment(@PathVariable(name = "id",required = false) Long id) {
        return iPaymentServicePort.getPayment(id);
    }

    @GetMapping(name = "/status")
    public String getStatusPayment(@PathVariable(name = "id",required = false) Long id) {
        return iPaymentServicePort.getStatusPayment(id);
    }

}
