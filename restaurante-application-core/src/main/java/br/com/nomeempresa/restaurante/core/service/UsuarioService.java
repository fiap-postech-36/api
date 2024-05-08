package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.Usuario;
import br.com.nomeempresa.restaurante.ports.in.UsuarioServicePort;
import br.com.nomeempresa.restaurante.ports.out.UsuarioPort;

public class UsuarioService implements UsuarioServicePort {

    private final UsuarioPort usuarioPort;


    public UsuarioService(UsuarioPort salvarUsuarioPort) {
        this.usuarioPort = salvarUsuarioPort;

    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioPort.salvar(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioPort.buscarPorId(id);
    }

    @Override
    public Usuario buscarPorCpf(String cpf) {
        return usuarioPort.buscarPorCpf(cpf);
    }

}