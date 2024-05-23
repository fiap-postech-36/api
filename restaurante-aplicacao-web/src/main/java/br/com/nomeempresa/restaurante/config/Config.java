package br.com.nomeempresa.restaurante.config;

import br.com.nomeempresa.restaurante.adapters.outbound.PaymentAdapter;
import br.com.nomeempresa.restaurante.adapters.outbound.UsuarioAdapter;
import br.com.nomeempresa.restaurante.core.service.PaymentService;
import br.com.nomeempresa.restaurante.core.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UsuarioService salvarUsuarioService(UsuarioAdapter salvarUsuarioAdapter){
        return new UsuarioService(salvarUsuarioAdapter);
    }

    @Bean
    public PaymentService beanPayment(PaymentAdapter paymentAdapter){
        return new PaymentService(paymentAdapter);
    }

}