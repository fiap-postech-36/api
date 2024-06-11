package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.core.domain.entities.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ConverterCategoryDomainEntity {

    public Category converterParaDominio(Category categoriaEnum){
        if(categoriaEnum==null){
            return null;
        }

        return Stream.of(Category.values())
                .filter(s -> s.name().equals(categoriaEnum.name()))
                .findFirst().orElse(null);
    }

    public Category converterParaEntidade(Category categoria){
        if(categoria==null){
            return null;
        }

        return Stream.of(Category.values())
                .filter(s -> s.name().equals(categoria.name()))
                .findFirst().orElse(null);
    }
}
