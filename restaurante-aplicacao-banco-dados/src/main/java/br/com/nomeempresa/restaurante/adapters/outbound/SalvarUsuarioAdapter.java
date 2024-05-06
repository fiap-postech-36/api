package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.EnderecoToEnderecoEntityMapper;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.UsuarioEntityToUsuarioMapper;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.UsuarioToUsuarioEntityMapper;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.UsuarioRepository;
import br.com.nomeempresa.restaurante.core.domain.Usuario;
import br.com.nomeempresa.restaurante.ports.out.SalvarUsuarioPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class SalvarUsuarioAdapter implements SalvarUsuarioPort {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioToUsuarioEntityMapper usuarioToUsuarioEntityMapper;

    private final UsuarioEntityToUsuarioMapper usuarioToUsuarioEntitymMapper;

    private final EnderecoToEnderecoEntityMapper enderecoToEnderecoEntityMapper;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var usuarioEntity = usuarioToUsuarioEntityMapper.mapper(usuario);
        var enderecoEntity = enderecoToEnderecoEntityMapper.mapper(usuario.getEndereco());
        usuarioEntity.setEndereco(enderecoEntity);
        return usuarioToUsuarioEntitymMapper.mapper(usuarioRepository.save(usuarioEntity));
    }
}
