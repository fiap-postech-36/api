package br.com.nomeempresa.restaurante.config;

import br.com.nomeempresa.restaurante.adapters.outbound.CustomerAdapter;
import br.com.nomeempresa.restaurante.adapters.outbound.OrderAdapter;
import br.com.nomeempresa.restaurante.adapters.outbound.ProductAdapter;
import br.com.nomeempresa.restaurante.adapters.outbound.PaymentAdapter;
import br.com.nomeempresa.restaurante.core.service.OrderService;
import br.com.nomeempresa.restaurante.core.service.ProductService;
import br.com.nomeempresa.restaurante.core.service.PaymentService;
import br.com.nomeempresa.restaurante.core.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public OrderService orderService(OrderAdapter orderAdapter){
        return new OrderService(orderAdapter);
    }


    @Bean
    public CustomerService usuarioServiceProduces(CustomerAdapter salvarUsuarioAdapter){
        return new CustomerService(salvarUsuarioAdapter);
    }

    @Bean
    public ProductService produtoServiceProduces(ProductAdapter produtoAdapter){
        return new ProductService(produtoAdapter);
    }

    @Bean
    public PaymentService paymentServiceProduces(PaymentAdapter paymentAdapter, OrderAdapter orderAdapter){
        return new PaymentService(paymentAdapter, this.orderService(orderAdapter));
    }
}