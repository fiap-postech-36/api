package br.com.nomeempresa.restaurante.ports.out;

import br.com.nomeempresa.restaurante.core.domain.Produto;
import br.com.nomeempresa.restaurante.core.domain.Categoria;

import java.util.Collection;

public interface ProdutoPort {

    Produto salvar(Produto produto);

    Produto editar(Produto produto);

    Produto buscarPorId(Long id);

    Collection<Produto> buscarPorCategoria(Categoria categoria);

}
