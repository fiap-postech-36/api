package br.com.nomeempresa.restaurante.adapters.inbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorRequestDominio;
import br.com.nomeempresa.restaurante.adapters.inbound.request.ProdutoRequest;
import br.com.nomeempresa.restaurante.adapters.inbound.request.UsuarioRequest;
import br.com.nomeempresa.restaurante.core.domain.Categoria;
import br.com.nomeempresa.restaurante.core.domain.Produto;
import br.com.nomeempresa.restaurante.core.domain.Usuario;
import br.com.nomeempresa.restaurante.ports.in.ProdutoServicePort;
import br.com.nomeempresa.restaurante.ports.in.UsuarioServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    private final ConversorRequestDominio conversor;

    @PostMapping
    public Produto salvarProduto(@RequestBody @Valid ProdutoRequest produtoRequest){
        var produto = conversor.converterProdutoParaDominio(produtoRequest);
        return produtoServicePort.salvar(produto);
    }

    @GetMapping
    public Collection<Produto> buscarPorCategoria(@RequestParam(name = "categoria",required = false) Categoria categoria){
        if(categoria!=null){
            return produtoServicePort.buscarPorCategoria(categoria);
        }
        return Collections.EMPTY_LIST;
    }
}