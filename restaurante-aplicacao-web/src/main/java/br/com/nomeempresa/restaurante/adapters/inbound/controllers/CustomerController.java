package br.com.nomeempresa.restaurante.adapters.inbound.controllers;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorRequestDominio;
import br.com.nomeempresa.restaurante.adapters.inbound.request.CustomerRequest;
import br.com.nomeempresa.restaurante.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.exception.CustomerAlreadyExistsException;
import br.com.nomeempresa.restaurante.exception.CustomerNotFoundException;
import br.com.nomeempresa.restaurante.ports.in.CustomerServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerServicePort customerServicePort;

    private final ConversorRequestDominio conversor;

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody @Valid CustomerRequest customerRequest, UriComponentsBuilder uriBuilder) {

        var customerDomain = conversor.convertCustomerToDomain(customerRequest);

        var customerHasAccount = Optional.ofNullable(customerServicePort.findByCpf(customerDomain.getCpf().getValue()));
        if (customerHasAccount.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists");
        }

        var customer = customerServicePort.save(customerDomain);
        var uri = uriBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(customer);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        Customer customerDomain = conversor.convertCustomerToDomain(customerRequest);

        boolean custumerExists = Optional.ofNullable(customerServicePort.findById(customerDomain.getId())).isPresent();
        if (!custumerExists) {
            throw new CustomerNotFoundException("Invalid Customer ID");
        }

        var cpfOwner = customerServicePort.findByCpf(customerDomain.getCpf().getValue());

        if (cpfOwner != null && !cpfOwner.getId().equals(customerDomain.getId())) {
            throw new CustomerAlreadyExistsException("CPF has already been registered by another customer");
        }

        Customer updatedCustomer = customerServicePort.update(customerDomain);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable(name = "id", required = false) Long id) {
        customerServicePort.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Customer>> findAllCustomers() {
        return ResponseEntity.ok(customerServicePort.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable(name = "id", required = false) Long id) {
        var customer = customerServicePort.findById(id);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }

        return ResponseEntity.ok(customer);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Customer> findCustomerByCpf(@PathVariable(name = "cpf", required = true) String cpf) {
        var customer = customerServicePort.findByCpf(cpf);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }

        return ResponseEntity.ok(customer);
    }

}