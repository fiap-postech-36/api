package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.UsuarioEntity;
import br.com.nomeempresa.restaurante.core.domain.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConversorUsuarioDominioEntidade {

    public Usuario converterParaDominio(Optional<UsuarioEntity> usuarioEntity){
       if(usuarioEntity.isPresent()){
           var usuario = new Usuario();
           BeanUtils.copyProperties(usuarioEntity.get(), usuario);
           return usuario;
       }
        return null;
    }

    public Usuario converterParaDominio(UsuarioEntity usuarioEntity){
        if(usuarioEntity==null){
            return null;
        }
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioEntity, usuario);
        return usuario;
    }

    public UsuarioEntity converterParaEntidade(Usuario usuario){
        if(usuario==null){
            return null;
        }
        var usuarioEntity = new UsuarioEntity();
        BeanUtils.copyProperties(usuario, usuarioEntity);
        return usuarioEntity;
    }
}
