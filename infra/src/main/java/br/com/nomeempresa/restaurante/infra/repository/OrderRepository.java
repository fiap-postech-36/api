package br.com.nomeempresa.restaurante.infra.repository;

import br.com.nomeempresa.restaurante.infra.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("select o from OrderEntity o where (:orderStatus is null or cast (o.status as string) = :orderStatus)")
    List<OrderEntity> findByStatus(final String orderStatus);
}
