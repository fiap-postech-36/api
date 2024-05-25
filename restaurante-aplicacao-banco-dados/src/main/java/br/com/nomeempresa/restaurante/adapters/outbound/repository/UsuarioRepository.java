package br.com.nomeempresa.restaurante.adapters.outbound.repository;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CustumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<CustumerEntity, Long> {

    @Query("select u from CustumerEntity u where u.cpf = ?1")
    Optional<CustumerEntity> buscarPorCpf(String cpf);
}
