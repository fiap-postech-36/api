package br.com.nomeempresa.restaurante.infra.mapper;

import br.com.nomeempresa.restaurante.domain.core.domain.valueobjects.CPF;
import br.com.nomeempresa.restaurante.domain.core.domain.valueobjects.Email;
import br.com.nomeempresa.restaurante.infra.entity.CustomerEntity;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    @Mappings({
        @Mapping(source = "email", target = "email", qualifiedByName = "mapEmail"),
        @Mapping(source = "cpf", target = "cpf", qualifiedByName = "mapCpf")})
    Customer customerEntityToCustomer(final CustomerEntity customerEntity);

    @Mappings({
        @Mapping(source = "email", target = "email", qualifiedByName = "mapEmailToString"),
        @Mapping(source = "cpf", target = "cpf", qualifiedByName = "mapCpfToString")})
    CustomerEntity customerToCustomerEntity(final Customer customer);

    @Named("mapEmail")
    default Email mapEmail(final String email) {
        return new Email(email);
    }

    @Named("mapCpf")
    default CPF mapCpf(final String cpf) {
        return new CPF(cpf);
    }

    @Named("mapEmailToString")
    default String mapEmailToString(final Email email) {
        return email.getValue();
    }

    @Named("mapCpfToString")
    default String mapCpfToString(final CPF cpf) {
        return cpf.getValue();
    }

}
