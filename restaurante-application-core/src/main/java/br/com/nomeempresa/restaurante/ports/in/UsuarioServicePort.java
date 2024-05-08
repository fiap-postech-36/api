package br.com.nomeempresa.restaurante.ports.in;


import br.com.nomeempresa.restaurante.core.domain.Usuario;

public interface UsuarioServicePort {
    Usuario salvar(Usuario usuario);
    Usuario buscarPorId(Long id);
    Usuario buscarPorCpf(String cpf);
}
