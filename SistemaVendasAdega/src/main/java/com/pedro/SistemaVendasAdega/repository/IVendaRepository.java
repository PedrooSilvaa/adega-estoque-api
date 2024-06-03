package com.pedro.SistemaVendasAdega.repository;

import com.pedro.SistemaVendasAdega.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVendaRepository extends JpaRepository<Venda, Integer> {
}
