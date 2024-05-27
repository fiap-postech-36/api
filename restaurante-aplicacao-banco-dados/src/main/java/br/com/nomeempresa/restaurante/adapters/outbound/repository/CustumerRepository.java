package br.com.nomeempresa.restaurante.adapters.outbound.repository;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustumerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("select u from CustomerEntity u where u.cpf = ?1")
    Optional<CustomerEntity> findByCpf(String cpf);
}
