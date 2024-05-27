package br.com.nomeempresa.restaurante.core.domain.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


public class Pedido implements Serializable {

    private Long identificadorPedido;
    private Customer usuario;
    private Collection<Produto> produtos;
    private Date dataHoraHoraCriação;
    private Date dataHoraFinalizacao;
    private StatusPedido status;

    public Long getIdentificadorPedido() {
        return identificadorPedido;
    }

    public void setIdentificadorPedido(Long identificadorPedido) {
        this.identificadorPedido = identificadorPedido;
    }

    public Customer getUsuario() {
        return usuario;
    }

    public void setUsuario(Customer usuario) {
        this.usuario = usuario;
    }

    public Collection<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Collection<Produto> produtos) {
        this.produtos = produtos;
    }

    public Date getDataHoraHoraCriação() {
        return dataHoraHoraCriação;
    }

    public void setDataHoraHoraCriação(Date dataHoraHoraCriação) {
        this.dataHoraHoraCriação = dataHoraHoraCriação;
    }

    public Date getDataHoraFinalizacao() {
        return dataHoraFinalizacao;
    }

    public void setDataHoraFinalizacao(Date dataHoraFinalizacao) {
        this.dataHoraFinalizacao = dataHoraFinalizacao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}