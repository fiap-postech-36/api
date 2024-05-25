package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.request.PaymentRequest;
import br.com.nomeempresa.restaurante.adapters.inbound.request.ProdutoRequest;
import br.com.nomeempresa.restaurante.adapters.inbound.request.UsuarioRequest;
import br.com.nomeempresa.restaurante.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.core.domain.entities.Produto;
import br.com.nomeempresa.restaurante.core.domain.entities.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConversorRequestDominio {

    public Usuario converterUsuarioParaDominio(UsuarioRequest usuarioRequest){
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, usuario);
        return usuario;
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