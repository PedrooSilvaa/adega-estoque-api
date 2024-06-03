package com.pedro.SistemaVendasAdega.web.controller;

import com.pedro.SistemaVendasAdega.model.Produto;
import com.pedro.SistemaVendasAdega.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sistema_vendas_adega/produtos")
public class ProdutoControler {

    private final ProdutoService produtoService;

    @PostMapping
    public Produto createProduct(@RequestBody Produto produto){
        return produtoService.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> listAllProducts(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Produto> findByCategoria(@PathVariable String categoria){
        return produtoService.listarProdutosPorCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable int id){
        return produtoService.buscarProdutoPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public Produto findByName(@PathVariable String nome){
        return produtoService.buscarProdutoPorNome(nome);
    }

    @PutMapping("/alterar/id/{id}")
    public Produto updateById(@PathVariable int id, @RequestBody Produto produto){
        return produtoService.alterarProdutoPorId(id, produto);
    }

    @PutMapping("/alterar/nome/{nome}")
    public Produto updateById(@PathVariable String nome, @RequestBody Produto produto){
        return produtoService.alterarProdutoPorNome(nome, produto);
    }

    @DeleteMapping("/delete/id/{id}")
    public Produto deleteProdutoById(@PathVariable int id){
        return produtoService.excluirProdutoPorId(id);
    }

    @DeleteMapping("/delete/nome/{nome}")
    public void deleteProdutoByNome(@PathVariable String nome){
        produtoService.excluirProdutoPorNome(nome);
    }
}
