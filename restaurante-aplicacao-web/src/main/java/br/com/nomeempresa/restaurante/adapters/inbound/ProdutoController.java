package br.com.nomeempresa.restaurante.adapters.inbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorRequestDominio;
import br.com.nomeempresa.restaurante.adapters.inbound.request.ProdutoRequest;
import br.com.nomeempresa.restaurante.adapters.inbound.request.UsuarioRequest;
import br.com.nomeempresa.restaurante.core.domain.Categoria;
import br.com.nomeempresa.restaurante.core.domain.Payment;
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

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable(name = "id",required = false) Long idProduto){
        produtoServicePort.excluir(idProduto);
    }

    @PutMapping
    public Produto alterarProduto(@RequestBody @Valid ProdutoRequest produtoRequest){
        var produto = conversor.converterProdutoParaDominio(produtoRequest);
        return produtoServicePort.editar(produto);
    }

    @GetMapping("/{id}")
    public Produto buscarPorID(@PathVariable(name = "id",required = false) Long id) {
        return produtoServicePort.buscarPorId(id);
    }

    @GetMapping
    public Collection<Produto> buscarTodos(){
        return produtoServicePort.buscarTodos();
    }

    @GetMapping("filtro")
    public Collection<Produto> filtrar(@RequestParam(name = "categoria",required = false) Categoria categoria){

        if(categoria!=null){
            return produtoServicePort.buscarPorCategoria(categoria);
        }

        return Collections.EMPTY_LIST;
    }
}