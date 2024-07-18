package br.com.nomeempresa.restaurante.infra.gateways;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.domain.gateway.CustomerGateway;
import br.com.nomeempresa.restaurante.infra.mapper.CustomerMapper;
import br.com.nomeempresa.restaurante.infra.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerGatewayImpl implements CustomerGateway {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper = CustomerMapper.INSTANCE;
    @Override
    public Optional<Customer> save(final Customer customer) {
        final var customerEntity = mapper.customerToCustomerEntity(customer);
        return Optional.ofNullable(mapper.customerEntityToCustomer(customerRepository.save(customerEntity)));
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(mapper.customerEntityToCustomer(customerRepository.findById(id).orElse(null)));
    }

    @Override
    public Optional<Customer> findByCpf(final String cpf) {
        return Optional.ofNullable(mapper.customerEntityToCustomer(customerRepository.findByCpf(cpf).orElse(null)));
    }

    @Override
    public Collection<Customer> findAll() {
        return customerRepository.findAll().stream()
            .map(mapper::customerEntityToCustomer)
            .toList();
    }

    @Override
    public Optional<Customer> update(final Customer customer) {
        return save(customer);
    }

    @Override
    public void delete(final Long idCustomer) {
        customerRepository.deleteById(idCustomer);
    }
}
