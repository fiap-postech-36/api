package br.com.nomeempresa.restaurante.infra.repository;

import br.com.nomeempresa.restaurante.infra.entity.ProductEntity;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("select p from ProductEntity p where p.category = ?1")
    Collection<ProductEntity> findByCategory(Category category);

    List<ProductEntity> findByIdIn(List<Long> ids);
}
