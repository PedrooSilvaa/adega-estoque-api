package com.pedro.SistemaVendasAdega.web.controller;

import com.pedro.SistemaVendasAdega.model.ItemVenda;
import com.pedro.SistemaVendasAdega.model.Venda;
import com.pedro.SistemaVendasAdega.service.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sistema_vendas_adega/vendas")
public class VendaController {

    private final VendaService vendaService;

    @PostMapping("/criar/nome/{nome}")
    public Venda createVendaPorNome(@PathVariable String nome, @RequestBody List<ItemVenda> itemVendas){
        return vendaService.criarVendaPorNome(nome, itemVendas);
    }
}
