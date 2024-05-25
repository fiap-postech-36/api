package br.com.nomeempresa.restaurante.adapters.inbound;

import br.com.nomeempresa.restaurante.adapters.inbound.mapper.ConversorRequestDominio;
import br.com.nomeempresa.restaurante.adapters.inbound.request.UsuarioRequest;
import br.com.nomeempresa.restaurante.core.domain.entities.Usuario;
import br.com.nomeempresa.restaurante.ports.in.UsuarioServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioServicePort usuarioServicePort;

    private final ConversorRequestDominio conversor;

    @PostMapping
    public Usuario salvarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){
        var usuario = conversor.converterUsuarioParaDominio(usuarioRequest);
        return usuarioServicePort.salvar(usuario);
    }

    @PutMapping
    public Usuario atualizarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){
        var usuario = conversor.converterUsuarioParaDominio(usuarioRequest);
        return usuarioServicePort.atualizar(usuario);
    }

    @DeleteMapping
    public void deletarUsuario(@PathVariable(name = "id",required = false) Long idUsuario){
         usuarioServicePort.deletar(idUsuario);
    }

    @GetMapping
    public Collection<Usuario> buscarTodos(){
        return usuarioServicePort.buscarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable(name = "id",required = false) Long id){
            return usuarioServicePort.buscarPorId(id);
    }

    @GetMapping("/cpf/{cpf}")
    public Usuario buscarUsuarioPorCpf(@PathVariable(name = "cpf",required = true) String cpf){
            return usuarioServicePort.buscarPorCpf(cpf);
    }

}