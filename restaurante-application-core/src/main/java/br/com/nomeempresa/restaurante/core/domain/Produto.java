package br.com.nomeempresa.restaurante.core.domain;

import java.io.Serializable;

public class Produto implements Serializable {

    private long identificadorProduto;
    private String nome, descricao,urlImagem;
    private double preco;
    private Categoria categoria;

    public long getIdentificadorProduto() {
        return identificadorProduto;
    }

    public void setIdentificadorProduto(long identificadorProduto) {
        this.identificadorProduto = identificadorProduto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }



    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
