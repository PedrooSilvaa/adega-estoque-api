package com.pedro.SistemaVendasAdega.repository;

import com.pedro.SistemaVendasAdega.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProdutoRepository extends JpaRepository<Produto, Integer> {

    Optional<Produto> findByNome(String nome);

    List<Produto> findByCategoria(String categoria);

    void deleteByNome(String nome);
}
