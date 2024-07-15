package br.com.nomeempresa.restaurante.domain.gateway;


import br.com.nomeempresa.restaurante.domain.core.domain.entities.Customer;

import java.util.Collection;
public interface CustomerGateway {
    Customer save(Customer usuario);
    Customer findById(Long id);
    Customer findByCpf(String cpf);
    Collection<Customer> findAll();
    Customer update(Customer usuario);
    void delete(Long idUsuario);
}
