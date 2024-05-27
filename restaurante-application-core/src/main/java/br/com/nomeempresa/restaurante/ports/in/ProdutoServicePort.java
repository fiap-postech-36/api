package br.com.nomeempresa.restaurante.ports.in;


import br.com.nomeempresa.restaurante.core.domain.entities.Produto;
import br.com.nomeempresa.restaurante.core.domain.entities.Categoria;

import java.util.Collection;

public interface ProdutoServicePort {

    Produto salvar(Produto produto);

    Produto editar(Produto produto);

    void excluir(Long id);

    Produto buscarPorId(Long id);

    Collection<Produto> buscarPorCategoria(Categoria categoria);

    Collection<Produto> buscarTodos();
}
