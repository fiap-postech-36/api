package br.com.nomeempresa.restaurante.ports.in;


import br.com.nomeempresa.restaurante.core.domain.entities.Custumer;

import java.util.Collection;
public interface CustumerServicePort {
    Custumer save(Custumer usuario);
    Custumer findById(Long id);
    Custumer findByCpf(String cpf);
    Collection<Custumer> findAll();
    Custumer update(Custumer usuario);
    void delete(Long idUsuario);
}
