package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConverterCustomerDomainEntity;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.CustumerRepository;
import br.com.nomeempresa.restaurante.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.ports.out.CustomerPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@AllArgsConstructor
public class CustomerAdapter implements CustomerPort {

    private final CustumerRepository customerRepository;

    private final ConverterCustomerDomainEntity converterCustomer;

    @Override
    @Transactional
    public Customer save(Customer customer) {
        var customerEntity = converterCustomer.convertToEntity(customer);
        return converterCustomer.converterToDomain(customerRepository.save(customerEntity));
    }

    @Override
    public Customer findById(Long id) {
        return converterCustomer.converterToDomain(
                customerRepository.findById(id)
        );
    }

    @Override
    public Customer findByCpf(String cpf) {
        return converterCustomer.converterToDomain(
                customerRepository.findByCpf(cpf)
        );
    }

    @Override
    public Customer update(Customer customer) {
        var customerEntity = converterCustomer.convertToEntity(customer);
        return converterCustomer.converterToDomain(customerRepository.save(customerEntity));
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Collection<Customer> findAll() {
        return converterCustomer.converterColecaoParaDominio(customerRepository.findAll());
    }
}
