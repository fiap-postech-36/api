package br.com.nomeempresa.restaurante.adapters.outbound;

import br.com.nomeempresa.restaurante.core.domain.Endereco;
import br.com.nomeempresa.restaurante.ports.out.BuscarEnderecoPort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component

public class BuscarEnderecoAdapter implements BuscarEnderecoPort {

    @Override
    public Endereco buscar(String cep) {
        RestClient restClient = RestClient.create();

        return  restClient.get()
                .uri("https://viacep.com.br/ws/{cep}/json", cep)
                .accept(APPLICATION_JSON)
                .retrieve()
                .body(Endereco.class);
}
}