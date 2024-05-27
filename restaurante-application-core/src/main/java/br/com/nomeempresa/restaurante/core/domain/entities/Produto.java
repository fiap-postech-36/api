package br.com.nomeempresa.restaurante.core.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Produto implements Serializable {

    private Long id;
    private String nome, descricao, urlImagem;
    private BigDecimal preco;
    private Categoria categoria;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Produto other) {
            return Objects.equals(this.id, other.getId())
                || Objects.equals(this.nome, other.getNome())
                && Objects.equals(categoria.getCode(), other.getCategoria().getCode());
        }
        return false;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
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

}
