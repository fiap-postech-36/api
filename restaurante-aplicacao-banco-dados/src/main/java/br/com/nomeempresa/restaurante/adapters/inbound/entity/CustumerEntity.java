package br.com.nomeempresa.restaurante.adapters.inbound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name = "usuario")
@Entity
@Getter
@Setter
public class CustumerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column( name = "nome",nullable = false ,length=50)
    private String nome;

    @Column( name = "cpf",nullable = false,unique=true,length=11)
    private String cpf;

    @Column( name = "email",nullable = false,length=50)
    private String email;

}
