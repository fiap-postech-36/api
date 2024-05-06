package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.EnderecoEntity;
import br.com.nomeempresa.restaurante.core.domain.Endereco;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EnderecoToEnderecoEntityMapper {

    public EnderecoEntity mapper(Endereco endereco){
        var enderecoEntity = new EnderecoEntity();
        BeanUtils.copyProperties(endereco, enderecoEntity);
        return enderecoEntity;
    }
}
