package br.com.nomeempresa.restaurante.ports.in;


import br.com.nomeempresa.restaurante.core.domain.entities.Customer;

import java.util.Collection;
public interface CustomerServicePort {
    Customer save(Customer usuario);
    Customer findById(Long id);
    Customer findByCpf(String cpf);
    Collection<Customer> findAll();
    Customer update(Customer usuario);
    void delete(Long idUsuario);
}
