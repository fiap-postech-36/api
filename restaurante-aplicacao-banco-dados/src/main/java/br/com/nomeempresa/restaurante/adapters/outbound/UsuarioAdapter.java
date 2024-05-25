package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorUsuarioDominioEntidade;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.UsuarioRepository;
import br.com.nomeempresa.restaurante.core.domain.Usuario;
import br.com.nomeempresa.restaurante.ports.out.UsuarioPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UsuarioAdapter implements UsuarioPort {

    private final UsuarioRepository usuarioRepository;

    private final ConversorUsuarioDominioEntidade conversorUsuario;

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
}
