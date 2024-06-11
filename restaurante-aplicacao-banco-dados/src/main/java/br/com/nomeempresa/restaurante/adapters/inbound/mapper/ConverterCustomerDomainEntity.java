package br.com.nomeempresa.restaurante.adapters.inbound.mapper;
import br.com.nomeempresa.restaurante.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.core.domain.valueObjects.CPF;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.CustomerEntity;

@Component
public class ConverterCustomerDomainEntity {

    public Customer converterToDomain(Optional<CustomerEntity> userEntity) {
        return userEntity.map(this::convertToDomainWithTreatment).orElse(null);
    }

        public Customer convertToDomainWithTreatment(CustomerEntity customerEntity) {
        try {
            return converterToDomain(customerEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Customer converterToDomain(CustomerEntity customerEntity) {
        // Implementação da conversão de UsuarioEntity para Usuario
        var customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setName(customerEntity.getName());
        customer.setCpf(new CPF(customerEntity.getCpf()));
        customer.setEmail(customerEntity.getEmail());
        return customer;
    }

    public CustomerEntity convertToEntity(Customer customer){
        // Implementação da conversão de Usuario para UsuarioEntity
        CustomerEntity customerEntity = new CustomerEntity();

        CPF cpf = customer.getCpf();

        customerEntity.setId(customer.getId());
        customerEntity.setName(customer.getName());
        customerEntity.setCpf(cpf.getValue());
        customerEntity.setEmail(customer.getEmail());
        return customerEntity;
    }

    public Collection<Customer> converterColecaoParaDominio(Collection<CustomerEntity> usersEntities) {
        return Optional.ofNullable(usersEntities)
                .map(entities -> entities.stream()
                        .map(this::convertToDomainWithTreatment)
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }
}
