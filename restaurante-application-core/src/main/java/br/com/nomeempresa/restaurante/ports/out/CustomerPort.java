package br.com.nomeempresa.restaurante.ports.out;

import br.com.nomeempresa.restaurante.core.domain.entities.Customer;

import java.util.Collection;

public interface CustomerPort {
    Customer save(Customer usuario);

    Customer findById(Long id);


    Customer findByCpf(String cpf);

    Customer update(Customer usuario);


    void delete(Long idUsuario);

    Collection<Customer> findAll();
}
