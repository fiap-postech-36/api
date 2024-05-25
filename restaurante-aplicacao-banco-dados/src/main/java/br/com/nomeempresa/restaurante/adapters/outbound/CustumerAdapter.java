package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorCustumerDomainEntity;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.UsuarioRepository;
import br.com.nomeempresa.restaurante.core.domain.entities.Usuario;
import br.com.nomeempresa.restaurante.ports.out.CustumerPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
@AllArgsConstructor
public class UsuarioAdapter implements CustumerPort {

    private final UsuarioRepository usuarioRepository;

    private final ConversorCustumerDomainEntity conversorUsuario;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var usuarioEntity = conversorUsuario.converterParaEntidade(usuario);
        return conversorUsuario.converterParaDominio(usuarioRepository.save(usuarioEntity));
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return conversorUsuario.converterParaDominio(
            usuarioRepository.findById(id)
                .orElseThrow()
        );
    }

    @Override
    public Usuario buscarPorCpf(String cpf) {
        return conversorUsuario.converterParaDominio(
            usuarioRepository.buscarPorCpf(cpf)
                .orElseThrow()
        );
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        var usuarioEntity = conversorUsuario.converterParaEntidade(usuario);
        return conversorUsuario.converterParaDominio(usuarioRepository.save(usuarioEntity));
    }

    @Override
    public void deletar(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public Collection<Usuario> buscarTodos() {
        return conversorUsuario.converterColecaoParaDominio(usuarioRepository.findAll());
    }
}
