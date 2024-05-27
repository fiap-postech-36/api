package br.com.nomeempresa.restaurante.adapters.inbound.mapper;

import br.com.nomeempresa.restaurante.adapters.inbound.request.OrderRequest;
import br.com.nomeempresa.restaurante.core.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderRequestMapper {
    OrderRequestMapper INSTANCE = Mappers.getMapper(OrderRequestMapper.class);

    Order orderRequestToOrder(final OrderRequest orderRequest);
    OrderRequest orderToOrderRequest(final Order order);

}
