package br.com.nomeempresa.restaurante.application.inout.mapper;

import br.com.nomeempresa.restaurante.application.inout.input.ProductInput;
import br.com.nomeempresa.restaurante.application.inout.output.ProductOutput;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductRequestResponseMapper {
    ProductRequestResponseMapper INSTANCE = Mappers.getMapper(ProductRequestResponseMapper.class);

    Product productRequestToProduct(final ProductInput productInput);
    ProductOutput productToProductResponse(final Product product);


}
