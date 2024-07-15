package br.com.nomeempresa.restaurante.infra.gateways;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.domain.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class CustomerGatewayImpl implements CustomerGateway {
    @Override
    public Customer save(Customer usuario) {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public Customer findByCpf(String cpf) {
        return null;
    }

    @Override
    public Collection<Customer> findAll() {
        return null;
    }

    @Override
    public Customer update(Customer usuario) {
        return null;
    }

    @Override
    public void delete(Long idUsuario) {

    }
}
