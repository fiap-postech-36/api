package br.com.nomeempresa.restaurante.ports.in;


import br.com.nomeempresa.restaurante.core.domain.entities.Usuario;
import java.util.Collection;
public interface UsuarioServicePort {
    Usuario salvar(Usuario usuario);
    Usuario buscarPorId(Long id);
    Usuario buscarPorCpf(String cpf);
    Collection<Usuario> buscarTodos();
    Usuario atualizar(Usuario usuario);
    void deletar(Long idUsuario);
}
