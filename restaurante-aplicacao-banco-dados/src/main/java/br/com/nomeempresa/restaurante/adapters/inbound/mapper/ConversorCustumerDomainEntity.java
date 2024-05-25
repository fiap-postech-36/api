package br.com.nomeempresa.restaurante.adapters.inbound.mapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.CustumerEntity;
import br.com.nomeempresa.restaurante.core.domain.entities.Usuario;

@Component
public class ConversorUsuarioDominioEntidade {

    public Usuario converterParaDominio(Optional<CustumerEntity> usuarioEntity) {
        return usuarioEntity.map(this::converterParaDominioComTratamento).orElse(null);
    }
    public Usuario converterParaDominioComTratamento(CustumerEntity usuarioEntity) {
        try {
            return converterParaDominio(usuarioEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario converterParaDominio(CustumerEntity usuarioEntity) {
        // Implementação da conversão de UsuarioEntity para Usuario
        Usuario usuario = new Usuario();
        usuario.setId(usuarioEntity.getId());
        usuario.setNome(usuarioEntity.getNome());
        usuario.setCpf(usuarioEntity.getCpf());
        usuario.setEmail(usuarioEntity.getEmail());
        return usuario;
    }

    public CustumerEntity converterParaEntidade(Usuario usuario){
        // Implementação da conversão de Usuario para UsuarioEntity
        CustumerEntity usuarioEntity = new CustumerEntity();
        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setCpf(usuario.getCpf());
        usuarioEntity.setEmail(usuario.getEmail());
        return usuarioEntity;
    }

    public Collection<Usuario> converterColecaoParaDominio(Collection<CustumerEntity> usuarioEntities) {
        return Optional.ofNullable(usuarioEntities)
                .map(entities -> entities.stream()
                        .map(this::converterParaDominioComTratamento)
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }
}
