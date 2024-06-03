package com.pedro.SistemaVendasAdega.web.controller;

import com.pedro.SistemaVendasAdega.model.Fiado;
import com.pedro.SistemaVendasAdega.service.FiadoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sistema_vendas_adega/fiados")
public class FiadoController {

    public final FiadoService fiadoService;

    @PostMapping("/criar/id/{clienteId}")
    public Fiado createFiadoById(@PathVariable int clienteId, @RequestBody Fiado fiado){
        return fiadoService.criarFiadoParaClientePorId(clienteId, fiado);
    }

    @PostMapping("/criar/nome/{clienteNome}")
    public Fiado createFiadoByNome(@PathVariable String clienteNome, @RequestBody Fiado fiado){
        return fiadoService.criarFiadoParaClientePorNome(clienteNome, fiado);
    }

    @PostMapping("/criar/apelido/{clienteApelido}")
    public Fiado createFiadoByApelido(@PathVariable String clienteApelido, @RequestBody Fiado fiado){
        return fiadoService.criarFiadoParaClientePorApelido(clienteApelido, fiado);
    }

    @GetMapping
    public List<Fiado> listAllFiados(){
        return fiadoService.listarTodosFiados();
    }

    @GetMapping("/buscar/id/{id}")
    public Fiado findByNome(@PathVariable int id){
        return fiadoService.buscarPorId(id);
    }

    @GetMapping("/buscar/nome/{nome}")
    public Fiado findByNome(@PathVariable String nome){
        return fiadoService.buscarFiadoPorNomeCliente(nome);
    }

    @PutMapping("/pagamento/nome/{nomeCliente}")
    public Fiado pagamentoByNome(@PathVariable String nomeCliente, @RequestBody Fiado fiado){
        return fiadoService.pagamentoPorNome(nomeCliente, fiado);
    }

    @PutMapping("/adicionando/nome/{nome}")
    public Fiado addByNome(@PathVariable String nome, @RequestBody Fiado fiado){
        return fiadoService.adicionandoValorFiadoPorNome(nome, fiado);
    }

    @DeleteMapping("/deletar/id/{id}")
    public void deleteById(@PathVariable int id){
        fiadoService.deletarPorId(id);
    }

}
