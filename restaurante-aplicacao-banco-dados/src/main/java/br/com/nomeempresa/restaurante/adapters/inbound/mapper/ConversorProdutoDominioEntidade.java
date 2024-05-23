package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CategoriaEnum;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProdutoEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.UsuarioEntity;
import br.com.nomeempresa.restaurante.core.domain.Categoria;
import br.com.nomeempresa.restaurante.core.domain.Produto;
import br.com.nomeempresa.restaurante.core.domain.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Component
public class ConversorProdutoDominioEntidade {


    public Produto converterParaDominio(Optional<ProdutoEntity> produtoEntity){
        if(produtoEntity.isPresent()){
            var produto = new Produto();
            BeanUtils.copyProperties(produtoEntity.get(), produto);
            return produto;
        }
        return null;
    }

    public Collection<Produto> converterColecaoParaDominio(Collection<ProdutoEntity> produtosEntity){
       if(produtosEntity!=null){

           Collection<Produto> produtos = new ArrayList<Produto>();

           for (ProdutoEntity pe : produtosEntity){
               var produto = new Produto();
               produtos.add(converterParaDominio(pe));
           }
           return produtos;
       }
        return null;
    }

    public Produto converterParaDominio(ProdutoEntity produtoEntity){
        if(produtoEntity==null){
            return null;
        }
        var produto = new Produto();
        BeanUtils.copyProperties(produtoEntity, produto);
        produto.setCategoria(Categoria.fromCode(produtoEntity.getCategoria().name()));
        return produto;
    }

    public ProdutoEntity converterParaEntidade(Produto produto){
        if(produto==null){
            return null;
        }
        var produtoEntity = new ProdutoEntity();
        BeanUtils.copyProperties(produto, produtoEntity);
        produtoEntity.setCategoria(CategoriaEnum.fromCode(produto.getCategoria().name()));
        return produtoEntity;
    }
}
