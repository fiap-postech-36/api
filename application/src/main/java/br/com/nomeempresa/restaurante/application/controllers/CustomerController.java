package br.com.nomeempresa.restaurante.application.controllers;

import br.com.nomeempresa.restaurante.application.exception.CustomerAlreadyExistsException;
import br.com.nomeempresa.restaurante.application.inout.mapper.CustomerRequestResponseMapper;
import br.com.nomeempresa.restaurante.application.inout.input.CustomerInput;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.domain.gateway.CustomerGateway;
import br.com.nomeempresa.restaurante.application.exception.CustomerNotFoundException;
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

    private final CustomerGateway customerGateway;

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody @Valid CustomerInput customerInput, UriComponentsBuilder uriBuilder) {

        final var customerDomain = CustomerRequestResponseMapper.INSTANCE.customerRequestToCustomer(customerInput);

        final var customerHasAccount = Optional.ofNullable(customerGateway.findByCpf(customerDomain.getCpf().getValue()));
        if (customerHasAccount.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists");
        }

        var customer = customerGateway.save(customerDomain);
        var uri = uriBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(customer);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid CustomerInput customerInput) {
        Customer customerDomain = CustomerRequestResponseMapper.INSTANCE.customerRequestToCustomer(customerInput);

        boolean custumerExists = Optional.ofNullable(customerGateway.findById(customerDomain.getId())).isPresent();
        if (!custumerExists) {
            throw new CustomerNotFoundException("Invalid Customer ID");
        }

        var cpfOwner = customerGateway.findByCpf(customerDomain.getCpf().getValue());

        if (cpfOwner != null && !cpfOwner.getId().equals(customerDomain.getId())) {
            throw new CustomerAlreadyExistsException("CPF has already been registered by another customer");
        }

        Customer updatedCustomer = customerGateway.update(customerDomain);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable(name = "id", required = false) Long id) {
        customerGateway.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Customer>> findAllCustomers() {
        return ResponseEntity.ok(customerGateway.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable(name = "id", required = false) Long id) {
        var customer = customerGateway.findById(id);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }

        return ResponseEntity.ok(customer);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Customer> findCustomerByCpf(@PathVariable(name = "cpf", required = true) String cpf) {
        var customer = customerGateway.findByCpf(cpf);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }

        return ResponseEntity.ok(customer);
    }

}