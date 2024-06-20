package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.request.PaymentRequest;
import br.com.nomeempresa.restaurante.adapters.inbound.request.ProductRequest;
import br.com.nomeempresa.restaurante.adapters.inbound.request.CustomerRequest;
import br.com.nomeempresa.restaurante.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.core.domain.entities.Product;
import br.com.nomeempresa.restaurante.core.domain.valueObjects.CPF;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConverterRequestDomain {

    public Customer convertCustomerToDomain (CustomerRequest customerRequest){
        var customer = new Customer();
        customer.setId(customerRequest.id());
        customer.setName(customerRequest.nome());
        if(customerRequest.cpf() != null){
            customer.setCpf(new CPF(customerRequest.cpf()));
        }
        customer.setEmail(customerRequest.email());
        return customer;
    }

    public Product convertProductToDomain(ProductRequest produtoRequest){
        var produto = new Product();
        BeanUtils.copyProperties(produtoRequest, produto);
        return produto;
    }

    public Payment converterPaymentToDomain(PaymentRequest paymentRequest){
        var payment = new Payment();
        BeanUtils.copyProperties(paymentRequest, payment);
        return payment;
    }

}