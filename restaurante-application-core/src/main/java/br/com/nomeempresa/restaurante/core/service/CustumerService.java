package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.entities.Custumer;
import br.com.nomeempresa.restaurante.ports.in.CustumerServicePort;
import br.com.nomeempresa.restaurante.ports.out.CustumerPort;

import java.util.Collection;
import java.util.List;

public class CustumerService implements CustumerServicePort {

    private final CustumerPort usuarioPort;

    public CustumerService(CustumerPort salvarUsuarioPort) {
        this.usuarioPort = salvarUsuarioPort;
    }

    @Override
    public Custumer save(Custumer usuario) {
        return usuarioPort.save(usuario);
    }

    @Override
    public Custumer findById(Long id) {
        return usuarioPort.findById(id);
    }

    @Override
    public Custumer findByCpf(String cpf) {
        return usuarioPort.findByCpf(cpf);
    }

    @Override
    public Collection<Custumer> findAll() {
        return List.of();
    }

    @Override
    public Custumer update(Custumer usuario) {
        return usuarioPort.update(usuario);
    }

    @Override
    public void delete(Long idUsuario) {
        usuarioPort.delete(idUsuario);
    }
}