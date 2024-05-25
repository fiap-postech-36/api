package br.com.nomeempresa.restaurante.adapters.inbound.controllers;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorRequestDominio;
import br.com.nomeempresa.restaurante.adapters.inbound.request.CustumerRequest;
import br.com.nomeempresa.restaurante.core.domain.entities.Custumer;
import br.com.nomeempresa.restaurante.ports.in.CustumerServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/usuario")
@AllArgsConstructor
public class CustumerController {

    private final CustumerServicePort usuarioServicePort;

    private final ConversorRequestDominio conversor;

    @PostMapping
    public Custumer salvarUsuario(@RequestBody @Valid CustumerRequest usuarioRequest){
        var usuario = conversor.convertCustumerToDomain(usuarioRequest);
        return usuarioServicePort.save(usuario);
    }

    @PutMapping
    public Custumer atualizarUsuario(@RequestBody @Valid CustumerRequest usuarioRequest){
        var usuario = conversor.convertCustumerToDomain(usuarioRequest);
        return usuarioServicePort.update(usuario);
    }

    @DeleteMapping
    public void deletarUsuario(@PathVariable(name = "id",required = false) Long idUsuario){
         usuarioServicePort.delete(idUsuario);
    }

    @GetMapping
    public Collection<Custumer> buscarTodos(){
        return usuarioServicePort.findAll();
    }

    @GetMapping("/{id}")
    public Custumer buscarUsuario(@PathVariable(name = "id",required = false) Long id){
        return usuarioServicePort.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public Custumer buscarUsuarioPorCpf(@PathVariable(name = "cpf",required = true) String cpf){
        return usuarioServicePort.findByCpf(cpf);
    }

}