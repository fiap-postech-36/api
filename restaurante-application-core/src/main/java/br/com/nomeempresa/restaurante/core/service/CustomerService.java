package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.ports.in.CustomerServicePort;
import br.com.nomeempresa.restaurante.ports.out.CustomerPort;

import java.util.Collection;

public class CustomerService implements CustomerServicePort {

    private final CustomerPort customerPort;

    public CustomerService(CustomerPort port) {
        this.customerPort = port;
    }

    @Override
    public Customer save(Customer customer) {
        return customerPort.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerPort.findById(id);
    }

    @Override
    public Customer findByCpf(String cpf) {
        return customerPort.findByCpf(cpf);
    }

    @Override
    public Collection<Customer> findAll() {
        return customerPort.findAll();
    }

    @Override
    public Customer update(Customer customer) {
        return customerPort.update(customer);
    }

    @Override
    public void delete(Long idUsuario) {
        customerPort.delete(idUsuario);
    }
}