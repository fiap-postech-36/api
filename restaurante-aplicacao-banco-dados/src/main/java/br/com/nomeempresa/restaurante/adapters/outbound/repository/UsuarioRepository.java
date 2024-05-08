package br.com.nomeempresa.restaurante.adapters.outbound.repository;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.UsuarioEntity;
import br.com.nomeempresa.restaurante.core.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query("select u from UsuarioEntity u where u.cpf = ?1")
    Optional<UsuarioEntity> buscarPorCpf(String cpf);
}
