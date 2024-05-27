package br.com.nomeempresa.restaurante.ports.out;

import br.com.nomeempresa.restaurante.core.domain.entities.Produto;
import br.com.nomeempresa.restaurante.core.domain.entities.Categoria;

import java.util.Collection;

public interface ProdutoPort {

    Produto salvar(Produto produto);

    Produto editar(Produto produto);

    void excluir(Long id);

    Produto buscarPorId(Long id);

    Collection<Produto> buscarPorCategoria(Categoria categoria);

    Collection<Produto> buscarTodos();

}
