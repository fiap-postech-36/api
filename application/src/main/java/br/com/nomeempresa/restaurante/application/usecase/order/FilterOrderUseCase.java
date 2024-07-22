package br.com.nomeempresa.restaurante.application.usecase.order;

import br.com.nomeempresa.restaurante.application.inout.input.FilterInput;
import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Order;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.OrderStatus;
import br.com.nomeempresa.restaurante.domain.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilterOrderUseCase implements UseCase<FilterInput, Page<Order>> {

    private final OrderGateway orderGateway;
    @Override
    public Optional<Page<Order>> execute(final FilterInput filterInput) {
        final var status = Objects.nonNull(filterInput.params()) ? OrderStatus.valueOf(filterInput.params().get("status")) : null;
        final List<Order> orders = (List<Order>) orderGateway.findByStatus(status);
        return Optional.of(new PageImpl<>(orders));
    }
}
