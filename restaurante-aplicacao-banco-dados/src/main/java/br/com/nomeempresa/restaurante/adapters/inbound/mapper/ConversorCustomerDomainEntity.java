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
public class ConversorCustomerDomainEntity {

    public Customer converterParaDominio(Optional<CustomerEntity> usuarioEntity) {
        return usuarioEntity.map(this::converterParaDominioComTratamento).orElse(null);
    }

    public Customer converterParaDominioComTratamento(CustomerEntity usuarioEntity) {
        try {
            return converterParaDominio(usuarioEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Customer converterParaDominio(CustomerEntity usuarioEntity) {
        // Implementação da conversão de UsuarioEntity para Usuario
        var usuario = new Customer();
        usuario.setId(usuarioEntity.getId());
        usuario.setName(usuarioEntity.getNome());
        usuario.setCpf(new CPF(usuarioEntity.getCpf()));
        usuario.setEmail(usuarioEntity.getEmail());
        return usuario;
    }

    public CustomerEntity converterParaEntidade(Customer usuario){
        // Implementação da conversão de Usuario para UsuarioEntity
        CustomerEntity usuarioEntity = new CustomerEntity();

        CPF cpf = usuario.getCpf();

        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNome(usuario.getName());
        usuarioEntity.setCpf(cpf.getValue());
        usuarioEntity.setEmail(usuario.getEmail());
        return usuarioEntity;
    }

    public Collection<Customer> converterColecaoParaDominio(Collection<CustomerEntity> usuarioEntities) {
        return Optional.ofNullable(usuarioEntities)
                .map(entities -> entities.stream()
                        .map(this::converterParaDominioComTratamento)
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }
}
