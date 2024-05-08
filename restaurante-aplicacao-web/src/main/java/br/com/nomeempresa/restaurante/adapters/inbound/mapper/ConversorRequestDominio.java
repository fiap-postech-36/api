package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.request.UsuarioRequest;
import br.com.nomeempresa.restaurante.core.domain.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConversorRequestDominio {

    public Usuario converterUsuarioParaDominio(UsuarioRequest usuarioRequest){
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, usuario);
        return usuario;
    }

}