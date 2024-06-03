package com.pedro.SistemaVendasAdega.web.controller;

import com.pedro.SistemaVendasAdega.model.Cliente;
import com.pedro.SistemaVendasAdega.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sistema_vendas_adega/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteService.criarCliente(cliente);
    }

    @GetMapping("/lista")
    public List<Cliente> listAll(){
        return clienteService.listarClientes();
    }

    @GetMapping("/lista/nome/{nome}")
    public List<Cliente> listAllByNome(@PathVariable String nome){
        return clienteService.listarClientePorNome(nome);
    }

    @GetMapping("/lista/apelido/{apelido}")
    public List<Cliente> listAllbyApelido(@PathVariable String apelido){
        return clienteService.listarClienteApelido(apelido);
    }

    @GetMapping("/buscar/id/{id}")
    public Cliente findById(@PathVariable int id){
        return clienteService.buscarClientePorId(id);
    }

    @PutMapping("alterar/id/{id}")
    public Cliente updateById(@PathVariable int id, @RequestBody Cliente cliente){
        return clienteService.alterarPorId(id, cliente);
    }

    @DeleteMapping("/deletar/id/{id}")
    public void deleteById(@PathVariable int id){
        clienteService.deletarClientePorId(id);
    }

    @DeleteMapping("/deletar/nome/{nome}")
    public void deleteByNome(@PathVariable String nome){
        clienteService.deletarClientePorNome(nome);
    }

    @DeleteMapping("/deletar/apelido/{apelido}")
    public void deleteByApelido(@PathVariable String apelido){
        clienteService.listarClienteApelido(apelido);
    }


}
