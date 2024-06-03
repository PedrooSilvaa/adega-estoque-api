package com.pedro.SistemaVendasAdega.repository;

import com.pedro.SistemaVendasAdega.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findAllByNome(String nome);
    List<Cliente> findAllByApelido(String apelido);


    void deleteByNome(String nome);

    void deleteByApelido(String apelido);

    Cliente findByNome(String nome);

    Cliente findByApelido(String apelido);
}
