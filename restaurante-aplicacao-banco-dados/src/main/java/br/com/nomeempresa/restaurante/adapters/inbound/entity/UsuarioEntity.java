package br.com.nomeempresa.restaurante.adapters.inbound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name = "usuario")
@Entity
@Getter
@Setter
public class UsuarioEntity{
    @Id
    @Column(name = "idUsuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long idUsuario;

    @Column( nullable = false )
    private String nome;

    @Column( nullable = false,unique=true,length=11)
    private String cpf;

    @Column( nullable = false,length=50)
    private String email;

}
