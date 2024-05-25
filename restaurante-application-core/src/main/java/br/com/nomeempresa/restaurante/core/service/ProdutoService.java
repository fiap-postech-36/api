package br.com.nomeempresa.restaurante.core.service;

import br.com.nomeempresa.restaurante.core.domain.entities.Produto;
import br.com.nomeempresa.restaurante.core.domain.entities.Categoria;
import br.com.nomeempresa.restaurante.ports.in.ProdutoServicePort;
import br.com.nomeempresa.restaurante.ports.out.ProdutoPort;

import java.util.Collection;

public class ProdutoService implements ProdutoServicePort {

    private final ProdutoPort produtoPort;


    public ProdutoService(ProdutoPort produtoPort) {
        this.produtoPort = produtoPort;

    }

    @Override
    public Produto salvar(Produto produto){
        return this.produtoPort.salvar(produto);
    }

    @Override
    public Produto editar(Produto produto){
        return this.produtoPort.editar(produto);

    }

    @Override
    public void excluir(Long id){
         this.produtoPort.excluir(id);
    }

    @Override
    public Produto buscarPorId(Long id){
        return this.produtoPort.buscarPorId(id);

    }

    @Override
    public Collection<Produto> buscarPorCategoria(Categoria categoria){
        return this.produtoPort.buscarPorCategoria(categoria);

    }

    @Override
    public Collection<Produto> buscarTodos(){
        return this.produtoPort.buscarTodos();
    }


}