package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.request.PaymentRequest;
import br.com.nomeempresa.restaurante.adapters.inbound.request.ProdutoRequest;
import br.com.nomeempresa.restaurante.adapters.inbound.request.CustumerRequest;
import br.com.nomeempresa.restaurante.core.domain.entities.Custumer;
import br.com.nomeempresa.restaurante.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.core.domain.entities.Produto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConversorRequestDominio {

    public Custumer convertCustumerToDomain (CustumerRequest custumerRequest){
        var custumer = new Custumer();
        BeanUtils.copyProperties(custumerRequest, custumer);
        return custumer;
    }

    public Produto converterProdutoParaDominio(ProdutoRequest produtoRequest){
        var produto = new Produto();
        BeanUtils.copyProperties(produtoRequest, produto);
        return produto;
    }

    public Payment converterPaymentToDomain(PaymentRequest paymentRequest){
        var payment = new Payment();
        BeanUtils.copyProperties(paymentRequest, payment);
        return payment;
    }

}