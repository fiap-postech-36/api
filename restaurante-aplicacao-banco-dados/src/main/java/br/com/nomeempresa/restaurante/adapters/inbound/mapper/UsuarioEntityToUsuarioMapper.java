package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.UsuarioEntity;
import br.com.nomeempresa.restaurante.core.domain.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityToUsuarioMapper {

    public Usuario mapper(UsuarioEntity usuarioEntity){
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioEntity, usuario);
        return usuario;
    }
}
