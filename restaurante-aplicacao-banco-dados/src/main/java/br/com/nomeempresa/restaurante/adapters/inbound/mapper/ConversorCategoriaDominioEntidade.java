package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CategoriaEnum;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProdutoEntity;
import br.com.nomeempresa.restaurante.core.domain.Categoria;
import br.com.nomeempresa.restaurante.core.domain.Produto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

@Component
public class ConversorCategoriaDominioEntidade {

    public Categoria converterParaDominio(CategoriaEnum categoriaEnum){
        if(categoriaEnum==null){
            return null;
        }

        return Stream.of(Categoria.values())
                .filter(s -> s.name().equals(categoriaEnum.name()))
                .findFirst().orElse(null);
    }

    public CategoriaEnum converterParaEntidade(Categoria categoria){
        if(categoria==null){
            return null;
        }

        return Stream.of(CategoriaEnum.values())
                .filter(s -> s.name().equals(categoria.name()))
                .findFirst().orElse(null);
    }
}
