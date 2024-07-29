package br.com.nomeempresa.restaurante.application.inout.mapper;

import br.com.nomeempresa.restaurante.application.inout.input.PaymentInput;
import br.com.nomeempresa.restaurante.application.inout.input.PaymentUpdateInput;
import br.com.nomeempresa.restaurante.application.inout.output.PaymentBalanceOutput;
import br.com.nomeempresa.restaurante.application.inout.output.PaymentOutput;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.infra.feign.presenter.request.PaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentInputOutputMapper {
    PaymentInputOutputMapper INSTANCE = Mappers.getMapper(PaymentInputOutputMapper.class);

    @Mapping(source = "order", target = "order", qualifiedByName = "mapOrderIdToOrder")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "client", target = "client")
    Payment paymentRequestToPayment(final PaymentInput paymentInput);

    @Mapping(source = "order", target = "order")
    @Mapping(source = "status", target = "status")
    Payment paymentUpdateRequestToPayment(final PaymentUpdateInput paymentInput);

    PaymentOutput paymentToPaymentResponse(final Payment payment);

    PaymentBalanceOutput paymentToPaymentBalanceOutput(final Payment payment);

    @Mapping(target = "description", source = "descripton")
    @Mapping(source = "amount", target = "transactionAmount")
    @Mapping(target = "paymentMethodId", source = "method")
    PaymentRequest paymentToPaymentRequest(PaymentInput payment);

    @Named("mapOrderIdToOrder")
    default Order mapOrderIdToOrder(final Long orderId) {
        return new Order(
            orderId,
            null,
            null,
            null,
            null

        );
    }

}
