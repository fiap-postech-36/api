package br.com.nomeempresa.restaurante.ports.out;

import br.com.nomeempresa.restaurante.core.domain.Usuario;

import java.util.Collection;

public interface UsuarioPort {
    Usuario salvar(Usuario usuario);

    Usuario buscarPorId(Long id);

    Usuario buscarPorCpf(String cpf);

    Usuario atualizar(Usuario usuario);

    void deletar(Long idUsuario);

    Collection<Usuario> buscarTodos();
}
