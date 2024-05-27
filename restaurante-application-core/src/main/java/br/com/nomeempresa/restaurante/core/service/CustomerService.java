package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.ports.in.CustomerServicePort;
import br.com.nomeempresa.restaurante.ports.out.CustomerPort;

import java.util.Collection;
import java.util.List;

public class CustomerService implements CustomerServicePort {

    private final CustomerPort usuarioPort;

    public CustomerService(CustomerPort salvarUsuarioPort) {
        this.usuarioPort = salvarUsuarioPort;
    }

    @Override
    public Customer save(Customer customer) {
        return usuarioPort.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return usuarioPort.findById(id);
    }

    @Override
    public Customer findByCpf(String cpf) {
        return usuarioPort.findByCpf(cpf);
    }

    @Override
    public Collection<Customer> findAll() {
        return usuarioPort.findAll();
    }

    @Override
    public Customer update(Customer customer) {
        return usuarioPort.update(customer);
    }

    @Override
    public void delete(Long idUsuario) {
        usuarioPort.delete(idUsuario);
    }
}