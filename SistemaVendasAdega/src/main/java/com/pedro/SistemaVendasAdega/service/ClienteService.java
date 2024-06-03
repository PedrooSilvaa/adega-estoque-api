package com.pedro.SistemaVendasAdega.service;

import com.pedro.SistemaVendasAdega.model.Cliente;
import com.pedro.SistemaVendasAdega.repository.IClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteService {

    private final IClienteRepository iClienteRepository;

    @Transactional
    public Cliente criarCliente(Cliente cliente){
        return iClienteRepository.save(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> listarClientes(){
        return iClienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Cliente> listarClientePorNome(String nome){
        return iClienteRepository.findAllByNome(nome);
    }

    @Transactional(readOnly = true)
    public List<Cliente> listarClienteApelido(String apelido){
        return iClienteRepository.findAllByApelido(apelido);
    }

    @Transactional(readOnly = true)
    public Cliente buscarClientePorId(int id) {
        return iClienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    @Transactional
    public Cliente alterarPorId(int id, Cliente clienteRequest) {
        Cliente cliente = buscarClientePorId(id);

        cliente.setNome(clienteRequest.getNome());
        cliente.setApelido(clienteRequest.getApelido());

        return iClienteRepository.save(cliente);
    }

    @Transactional
    public void deletarClientePorId(int id){
        iClienteRepository.deleteById(id);
    }

    @Transactional
    public void deletarClientePorNome(String nome){
        iClienteRepository.deleteByNome(nome);
    }

    @Transactional
    public void deletarClientePorApelido(String apelido){
        iClienteRepository.deleteByApelido(apelido);
    }


}
