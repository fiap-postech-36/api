package br.com.nomeempresa.restaurante.infra.repository;

import br.com.nomeempresa.restaurante.infra.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("select u from CustomerEntity u where u.cpf = ?1")
    Optional<CustomerEntity> findByCpf(String cpf);
}
