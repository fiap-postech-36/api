package br.com.nomeempresa.restaurante.application.usecase.customer;

import br.com.nomeempresa.restaurante.application.inout.input.CustomerInput;
import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Customer;
import br.com.nomeempresa.restaurante.domain.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditCustomerUseCase implements UseCase<CustomerInput, Customer> {

    private final CustomerGateway customerGateway;
    @Override
    public Optional<Customer> execute(final CustomerInput customerInput) {
        return Optional.empty();
    }
}
