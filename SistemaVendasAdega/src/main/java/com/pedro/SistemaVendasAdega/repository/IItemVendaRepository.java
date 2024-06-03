package com.pedro.SistemaVendasAdega.repository;

import com.pedro.SistemaVendasAdega.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemVendaRepository extends JpaRepository<ItemVenda, Integer> {
}
