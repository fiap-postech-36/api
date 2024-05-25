package br.com.nomeempresa.restaurante.adapters.inbound.mapper;
import br.com.nomeempresa.restaurante.core.domain.entities.Custumer;
import br.com.nomeempresa.restaurante.core.domain.valueObjects.CPF;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.CustumerEntity;

@Component
public class ConversorCustumerDomainEntity {

    public Custumer converterParaDominio(Optional<CustumerEntity> usuarioEntity) {
        return usuarioEntity.map(this::converterParaDominioComTratamento).orElse(null);
    }

    public Custumer converterParaDominioComTratamento(CustumerEntity usuarioEntity) {
        try {
            return converterParaDominio(usuarioEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Custumer converterParaDominio(CustumerEntity usuarioEntity) {
        // Implementação da conversão de UsuarioEntity para Usuario
        var usuario = new Custumer();
        usuario.setId(usuarioEntity.getId());
        usuario.setName(usuarioEntity.getNome());
        usuario.setCpf(new CPF(usuarioEntity.getCpf()));
        usuario.setEmail(usuarioEntity.getEmail());
        return usuario;
    }

    public CustumerEntity converterParaEntidade(Custumer usuario){
        // Implementação da conversão de Usuario para UsuarioEntity
        CustumerEntity usuarioEntity = new CustumerEntity();

        CPF cpf = usuario.getCpf();

        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNome(usuario.getName());
        usuarioEntity.setCpf(cpf.getValue());
        usuarioEntity.setEmail(usuario.getEmail());
        return usuarioEntity;
    }

    public Collection<Custumer> converterColecaoParaDominio(Collection<CustumerEntity> usuarioEntities) {
        return Optional.ofNullable(usuarioEntities)
                .map(entities -> entities.stream()
                        .map(this::converterParaDominioComTratamento)
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }
}
