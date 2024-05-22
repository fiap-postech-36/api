package br.com.nomeempresa.restaurante.config;

import br.com.nomeempresa.restaurante.adapters.outbound.Produtodapter;
import br.com.nomeempresa.restaurante.adapters.outbound.UsuarioAdapter;
import br.com.nomeempresa.restaurante.core.service.ProdutoService;
import br.com.nomeempresa.restaurante.core.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UsuarioService usuarioServiceProduces(UsuarioAdapter salvarUsuarioAdapter){
        return new UsuarioService(salvarUsuarioAdapter);
    }

    @Bean
    public ProdutoService produtoServiceProduces(Produtodapter produtoAdapter){
        return new ProdutoService(produtoAdapter);
    }
}