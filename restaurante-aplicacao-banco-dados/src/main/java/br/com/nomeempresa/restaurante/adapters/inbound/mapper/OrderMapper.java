package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.OrderEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProdutoEntity;
import br.com.nomeempresa.restaurante.core.domain.Order;
import br.com.nomeempresa.restaurante.core.domain.entities.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order orderEntityToOrder(final OrderEntity orderEntity);
    @Mapping(source = "products", target = "products", qualifiedByName = "mapProdutosToProdutoItems")
    OrderEntity orderToOrderEntity(final Order order);

    @Named("mapProdutosToProdutoItems")
    default List<ProdutoEntity> mapProdutosToProdutoItems(List<Produto> produtos) {
        return produtos.stream()
            .map(this::mapProdutoToProdutoItem)
            .collect(Collectors.toList());
    }

    default ProdutoEntity mapProdutoToProdutoItem(Produto produto) {
        return new ProdutoEntity(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getUrlImagem(),
            produto.getPreco(),
            produto.getCategoria());
    }

}
