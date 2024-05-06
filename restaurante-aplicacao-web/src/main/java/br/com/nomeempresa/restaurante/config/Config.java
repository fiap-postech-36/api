package br.com.nomeempresa.restaurante.config;

import br.com.nomeempresa.restaurante.adapters.outbound.BuscarEnderecoAdapter;
import br.com.nomeempresa.restaurante.adapters.outbound.SalvarUsuarioAdapter;
import br.com.nomeempresa.restaurante.core.service.SalvarUsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SalvarUsuarioService salvarUsuarioService(SalvarUsuarioAdapter salvarUsuarioAdapter, BuscarEnderecoAdapter buscarEnderecoAdapter){
        return new SalvarUsuarioService(salvarUsuarioAdapter, buscarEnderecoAdapter);
    }
}