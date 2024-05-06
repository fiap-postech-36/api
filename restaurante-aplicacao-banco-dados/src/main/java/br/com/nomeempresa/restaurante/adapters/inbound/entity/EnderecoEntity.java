package br.com.nomeempresa.restaurante.adapters.inbound.entity;

import br.com.nomeempresa.restaurante.core.domain.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class EnderecoEntity{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    private String cep;

    private String logradouro;

    private String uf;

    private String cidade;

}