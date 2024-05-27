package br.com.nomeempresa.restaurante.adapters.outbound.repository;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CategoriaEnum;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    @Query("select p from ProdutoEntity p where p.categoria = ?1")
    Collection<ProdutoEntity> buscarPorCategoria(CategoriaEnum categoria);
}
