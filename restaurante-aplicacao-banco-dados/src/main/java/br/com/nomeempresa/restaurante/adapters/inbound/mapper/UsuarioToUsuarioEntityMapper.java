package br.com.nomeempresa.restaurante.adapters.inbound.mapper;


import br.com.nomeempresa.restaurante.adapters.inbound.entity.UsuarioEntity;
import br.com.nomeempresa.restaurante.core.domain.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioToUsuarioEntityMapper {

    public UsuarioEntity mapper(Usuario usuario){
        var usuarioEntity = new UsuarioEntity();
        BeanUtils.copyProperties(usuario, usuarioEntity);
        return usuarioEntity;
    }
}
