package br.com.nomeempresa.restaurante.domain.gateway;


import br.com.nomeempresa.restaurante.domain.core.domain.entities.Customer;

import java.util.Collection;
import java.util.Optional;

public interface CustomerGateway {
    Optional<Customer> save(final Customer usuario);
    Optional<Customer> findById(final Long id);
    Optional<Customer> findByCpf(final String cpf);
    Collection<Customer> findAll();
    Optional<Customer> update(final Customer usuario);

    Collection<Customer> filter(final String name, String cpf);
    void delete(final Long idUsuario);
}
