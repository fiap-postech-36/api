package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CategoriaEnum;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProdutoEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorProdutoDominioEntidade;
import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorCategoriaDominioEntidade;
import br.com.nomeempresa.restaurante.adapters.outbound.repository.ProdutoRepository;
import br.com.nomeempresa.restaurante.core.domain.Categoria;
import br.com.nomeempresa.restaurante.core.domain.Produto;
import br.com.nomeempresa.restaurante.ports.out.ProdutoPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
@AllArgsConstructor
public class Produtodapter implements ProdutoPort {

    private final ProdutoRepository produtoRepository;

    private final ConversorProdutoDominioEntidade conversorProduto;
    private final ConversorCategoriaDominioEntidade conversorCategoria;

    @Override
    @Transactional
    public Produto salvar(Produto produto) {
        var produtoEntity = conversorProduto.converterParaEntidade(produto);
        return conversorProduto.converterParaDominio(produtoRepository.save(produtoEntity));
    }

    @Override
    @Transactional
    public Produto editar(Produto produto) {
        ProdutoEntity produtoEntity = produtoRepository.findById(produto.getIdentificadorProduto())
            .orElseThrow();

        produtoEntity.setNome(produto.getNome());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setPreco(produto.getPreco());
        produtoEntity.setUrlImagem(produto.getUrlImagem());
        return conversorProduto.converterParaDominio(produtoRepository.save(produtoEntity));

    }

    @Override
    public Produto buscarPorId(Long id) {
        return conversorProduto.converterParaDominio(produtoRepository.findById(id)
            .orElseThrow());
    }

    @Override
    public Collection<Produto> buscarPorCategoria(Categoria categoria) {

        CategoriaEnum categoriaEntidade = conversorCategoria.converterParaEntidade(categoria);
        Collection<Produto> produtos = conversorProduto.converterColecaoParaDominio(produtoRepository.buscarPorCategoria(categoriaEntidade));
        return produtos;
    }
}
