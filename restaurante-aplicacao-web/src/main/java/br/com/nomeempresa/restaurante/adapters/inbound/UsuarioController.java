package br.com.nomeempresa.restaurante.adapters.inbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorRequestDominio;
import br.com.nomeempresa.restaurante.adapters.inbound.request.UsuarioRequest;
import br.com.nomeempresa.restaurante.core.domain.Usuario;
import br.com.nomeempresa.restaurante.ports.in.UsuarioServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioServicePort salvarUsuarioServicePort;

    private final ConversorRequestDominio conversor;

    @PostMapping
    public Usuario salvarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        var usuario = conversor.converterUsuarioParaDominio(usuarioRequest);
        return salvarUsuarioServicePort.salvar(usuario);
    }

    @GetMapping
    public Usuario buscarUsuario(@RequestParam(name = "id",required = false) Long idUsuario, @RequestParam(name = "cpf",required = false) String cpf){
        if(idUsuario!=null){
            return salvarUsuarioServicePort.buscarPorId(idUsuario);
        }
        if(cpf!=null){
            return salvarUsuarioServicePort.buscarPorCpf(cpf);
        }
        return null;
    }

}