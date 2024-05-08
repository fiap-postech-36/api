package br.com.nomeempresa.restaurante.ports.out;

import br.com.nomeempresa.restaurante.core.domain.Usuario;

public interface UsuarioPort {
    Usuario salvar(Usuario usuario);

    Usuario buscarPorId(Long id);

    Usuario buscarPorCpf(String cpf);
}
