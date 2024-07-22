package br.com.nomeempresa.restaurante.infra.repository;

import br.com.nomeempresa.restaurante.infra.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>  {
}
