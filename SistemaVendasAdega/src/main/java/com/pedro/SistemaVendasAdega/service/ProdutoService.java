package com.pedro.SistemaVendasAdega.service;

import com.pedro.SistemaVendasAdega.model.Produto;
import com.pedro.SistemaVendasAdega.repository.IProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ProdutoService {

    private final IProdutoRepository iProdutoRepository;

    @Transactional
    public Produto criarProduto(Produto produto){
        return iProdutoRepository.save(produto);
    }

    @Transactional(readOnly = true)
    public List<Produto> listarProdutos(){
        return iProdutoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Produto> listarProdutosPorCategoria(String categoria) {
        return iProdutoRepository.findByCategoria(categoria);
    }

    @Transactional(readOnly = true)
    public Produto buscarProdutoPorId(int id){
        return iProdutoRepository.findById(id).orElseThrow( () -> new RuntimeException("Produto não encontrado"));
    }

    @Transactional(readOnly = true)
    public Produto buscarProdutoPorNome(String nome){
        return iProdutoRepository.findByNome(nome).orElseThrow( () -> new RuntimeException("Produto não encontrado"));
    }

    @Transactional
    public Produto alterarProdutoPorId(int id, Produto produtoRequest) {

        Produto produto = buscarProdutoPorId(id);

        produto.setNome(produtoRequest.getNome());
        produto.setPreco(produtoRequest.getPreco());
        produto.setQuantidade(produtoRequest.getQuantidade());
        produto.setCategoria(produtoRequest.getCategoria());

        return iProdutoRepository.save(produto);

    }

    @Transactional
    public Produto alterarProdutoPorNome(String nome, Produto produtoRequest) {

        Produto produto = buscarProdutoPorNome(nome);

        produto.setNome(produtoRequest.getNome());
        produto.setPreco(produtoRequest.getPreco());
        produto.setQuantidade(produtoRequest.getQuantidade());
        produto.setCategoria(produtoRequest.getCategoria());

        return iProdutoRepository.save(produto);

    }

    @Transactional
    public Produto excluirProdutoPorId(int id){
        iProdutoRepository.deleteById(id);
        return buscarProdutoPorId(id);
    }

    @Transactional
    public void excluirProdutoPorNome(String nome){
        if (iProdutoRepository.findByNome(nome).isPresent()) {
            iProdutoRepository.deleteByNome(nome);
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }


}
