package br.com.nomeempresa.restaurante.adapters.outbound.repository;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CategoriaEnum;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.ProdutoEntity;
import br.com.nomeempresa.restaurante.adapters.inbound.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    @Query("select p from ProdutoEntity p where p.categoria = ?1")
    Collection<ProdutoEntity> buscarPorCategoria(CategoriaEnum categoria);
}
