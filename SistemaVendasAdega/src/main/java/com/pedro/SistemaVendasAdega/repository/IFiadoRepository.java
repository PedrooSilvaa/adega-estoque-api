package com.pedro.SistemaVendasAdega.repository;

import com.pedro.SistemaVendasAdega.model.Fiado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IFiadoRepository extends JpaRepository<Fiado, Integer> {
    @Query("SELECT f FROM Fiado f WHERE f.cliente.nome = :nome")
    Optional<Fiado> findByClienteNome(@Param("nome") String nome);

}
