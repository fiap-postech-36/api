package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorCustumerDomainEntity;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.UsuarioRepository;
import br.com.nomeempresa.restaurante.core.domain.entities.Custumer;
import br.com.nomeempresa.restaurante.ports.out.CustumerPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@AllArgsConstructor
public class CustumerAdapter implements CustumerPort {

    private final UsuarioRepository usuarioRepository;

    private final ConversorCustumerDomainEntity conversorUsuario;

    @Override
    @Transactional
    public Custumer save(Custumer usuario) {
        var usuarioEntity = conversorUsuario.converterParaEntidade(usuario);
        return conversorUsuario.converterParaDominio(usuarioRepository.save(usuarioEntity));
    }

    @Override
    public Custumer findById(Long id) {
        return conversorUsuario.converterParaDominio(
                usuarioRepository.findById(id)
                        .orElseThrow()
        );
    }

    @Override
    public Custumer findByCpf(String cpf) {
        return conversorUsuario.converterParaDominio(
                usuarioRepository.buscarPorCpf(cpf)
                        .orElseThrow()
        );
    }

    @Override
    public Custumer update(Custumer usuario) {
        var usuarioEntity = conversorUsuario.converterParaEntidade(usuario);
        return conversorUsuario.converterParaDominio(usuarioRepository.save(usuarioEntity));
    }

    @Override
    public void delete(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public Collection<Custumer> findAll() {
        return conversorUsuario.converterColecaoParaDominio(usuarioRepository.findAll());
    }
}
