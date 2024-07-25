package br.com.nomeempresa.restaurante.infra.mapper;

import br.com.nomeempresa.restaurante.domain.core.domain.entities.Payment;
import br.com.nomeempresa.restaurante.infra.feign.presenter.request.PaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeneratedQrCodeMapper {

    GeneratedQrCodeMapper INTANCE = Mappers.getMapper(GeneratedQrCodeMapper.class);

    @Mapping(target = "description", constant = "Pagamento do pedido") // Exemplo de mapeamento com valor constante
    @Mapping(source = "amount", target = "transactionAmount")
    @Mapping(target = "paymentMethodId", constant = "pix") // Método de pagamento PIX
    PaymentRequest paymentToPaymentRequest(Payment payment);

}
