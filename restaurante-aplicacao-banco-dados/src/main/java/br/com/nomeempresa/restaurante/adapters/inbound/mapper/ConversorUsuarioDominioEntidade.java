package br.com.nomeempresa.restaurante.adapters.inbound.mapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.UsuarioEntity;
import br.com.nomeempresa.restaurante.core.domain.Usuario;

@Component
public class ConversorUsuarioDominioEntidade {

    public Usuario converterParaDominio(Optional<UsuarioEntity> usuarioEntity) {
        return usuarioEntity.map(this::converterParaDominioComTratamento).orElse(null);
    }
    public Usuario converterParaDominioComTratamento(UsuarioEntity usuarioEntity) {
        try {
            return converterParaDominio(usuarioEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario converterParaDominio(UsuarioEntity usuarioEntity) {
        // Implementação da conversão de UsuarioEntity para Usuario
        Usuario usuario = new Usuario();
        usuario.setId(usuarioEntity.getId());
        usuario.setNome(usuarioEntity.getNome());
        usuario.setCpf(usuarioEntity.getCpf());
        usuario.setEmail(usuarioEntity.getEmail());
        return usuario;
    }

    public UsuarioEntity converterParaEntidade(Usuario usuario){
        // Implementação da conversão de Usuario para UsuarioEntity
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setCpf(usuario.getCpf());
        usuarioEntity.setEmail(usuario.getEmail());
        return usuarioEntity;
    }

    public Collection<Usuario> converterColecaoParaDominio(Collection<UsuarioEntity> usuarioEntities) {
        return Optional.ofNullable(usuarioEntities)
                .map(entities -> entities.stream()
                        .map(this::converterParaDominioComTratamento)
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }
}
