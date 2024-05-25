package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CategoriaEnum;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProdutoEntity;
import br.com.nomeempresa.restaurante.core.domain.Categoria;
import br.com.nomeempresa.restaurante.core.domain.Produto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Component
public class ConversorProdutoDominioEntidade {


    public ProdutoEntity converterParaEntidade(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(produto.getId());
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setPreco(produto.getPreco());
        produtoEntity.setUrlImagem(produto.getUrlImagem());
        produtoEntity.setCategoria(CategoriaEnum.fromCode(produto.getCategoria().name()));
        return produtoEntity;
    }

    public Collection<Produto> converterColecaoParaDominio(Collection<ProdutoEntity> produtosEntity) {
        return Optional.ofNullable(produtosEntity)
                .map(entities -> entities.stream()
                        .map(this::converterParaDominioComTratamento)
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }

    public Produto converterParaDominioComTratamento(ProdutoEntity produtoEntity) {
        try {
            return converterParaDominio(produtoEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Produto converterParaDominio(ProdutoEntity produtoEntity) {
        Produto produto = new Produto();
        produto.setId(produtoEntity.getId());
        produto.setNome(produtoEntity.getNome());
        produto.setPreco(produtoEntity.getPreco());
        produto.setDescricao(produtoEntity.getDescricao());
        produto.setUrlImagem(produtoEntity.getUrlImagem());
        produto.setCategoria(Categoria.fromCode(produtoEntity.getCategoria().name()));
        return produto;
    }

    public Produto converterParaDominio(Optional<ProdutoEntity> produtoEntity) {
        return produtoEntity.map(this::converterParaDominioComTratamento).orElse(null);
    }

}
