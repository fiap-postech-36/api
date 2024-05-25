package br.com.nomeempresa.restaurante.adapters.inbound.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiErrorMessage {

    private HttpStatus status;
    private List<String> errors;
}
