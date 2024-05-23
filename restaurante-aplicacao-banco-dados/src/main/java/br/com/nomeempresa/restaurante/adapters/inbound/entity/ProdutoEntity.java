package br.com.nomeempresa.restaurante.adapters.inbound.entity;

import br.com.nomeempresa.restaurante.adapters.inbound.types.CategoriaType;
import br.com.nomeempresa.restaurante.core.domain.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Table(name = "produto")
@Entity
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @Column(name = "identificadorproduto", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private long identificadorProduto;

    @Column( nullable = false,unique=true,length=50)
    private String nome;

    @Column( nullable = false,length=500)
    private String descricao;

    @Column( name = "urlimagem",nullable = false,length=200)
    private String urlImagem;

    @Column( nullable = false)
    private double preco;

    @Enumerated(EnumType.STRING)
    @Type(CategoriaType.class)
    private CategoriaEnum categoria;

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public long getIdentificadorProduto() {
        return identificadorProduto;
    }

    public void setIdentificadorProduto(long identificadorProduto) {
        this.identificadorProduto = identificadorProduto;
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



    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }
}
