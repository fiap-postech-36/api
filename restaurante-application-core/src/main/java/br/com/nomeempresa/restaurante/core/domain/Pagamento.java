package br.com.nomeempresa.restaurante.core.domain;

import java.io.Serializable;
import java.util.Date;

public class Pagamento implements Serializable {

    private String identificadorPagamento;
    private String identificadorExternoSistemaPagamento;
    private Date dataPagamento;
    private StatusPagamento status;
    private String descricaoErroPagamento;
    private String qrCodeBase64;
    private Double valorPagamento;


    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getIdentificadorPagamento() {
        return identificadorPagamento;
    }

    public void setIdentificadorPagamento(String identificadorPagamento) {
        this.identificadorPagamento = identificadorPagamento;
    }

    public String getIdentificadorExternoSistemaPagamento() {
        return identificadorExternoSistemaPagamento;
    }

    public void setIdentificadorExternoSistemaPagamento(String identificadorExternoSistemaPagamento) {
        this.identificadorExternoSistemaPagamento = identificadorExternoSistemaPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public String getDescricaoErroPagamento() {
        return descricaoErroPagamento;
    }

    public void setDescricaoErroPagamento(String descricaoErroPagamento) {
        this.descricaoErroPagamento = descricaoErroPagamento;
    }

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }
}