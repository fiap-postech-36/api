package br.com.nomeempresa.restaurante.ports.out;

import br.com.nomeempresa.restaurante.core.domain.Endereco;

public interface BuscarEnderecoPort {
    Endereco buscar(String cep);
}