package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorCustomerDomainEntity;
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

    private final CustumerRepository usuarioRepository;

    private final ConversorCustomerDomainEntity conversorUsuario;

    @Override
    @Transactional
    public Customer save(Customer usuario) {
        var usuarioEntity = conversorUsuario.converterParaEntidade(usuario);
        return conversorUsuario.converterParaDominio(usuarioRepository.save(usuarioEntity));
    }

    @Override
    public Customer findById(Long id) {
        return conversorUsuario.converterParaDominio(
                usuarioRepository.findById(id)
        );
    }

    @Override
    public Customer findByCpf(String cpf) {
        return conversorUsuario.converterParaDominio(
                usuarioRepository.findByCpf(cpf)
        );
    }

    @Override
    public Customer update(Customer usuario) {
        var usuarioEntity = conversorUsuario.converterParaEntidade(usuario);
        return conversorUsuario.converterParaDominio(usuarioRepository.save(usuarioEntity));
    }

    @Override
    public void delete(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public Collection<Customer> findAll() {
        return conversorUsuario.converterColecaoParaDominio(usuarioRepository.findAll());
    }
}
