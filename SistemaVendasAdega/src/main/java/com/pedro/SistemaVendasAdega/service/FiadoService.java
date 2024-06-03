package com.pedro.SistemaVendasAdega.service;

import com.pedro.SistemaVendasAdega.model.Cliente;
import com.pedro.SistemaVendasAdega.model.Fiado;
import com.pedro.SistemaVendasAdega.repository.IClienteRepository;
import com.pedro.SistemaVendasAdega.repository.IFiadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class FiadoService {


    private final IClienteRepository iClienteRepository;

    private final IFiadoRepository iFiadoRepository;


    @Transactional
    public Fiado criarFiadoParaClientePorId(int clienteId, Fiado fiado){
        Cliente cliente = iClienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        fiado.setCliente(cliente);
        return iFiadoRepository.save(fiado);
    }

    @Transactional
    public Fiado criarFiadoParaClientePorNome(String clienteNome, Fiado fiado){
        Cliente cliente = iClienteRepository.findByNome(clienteNome);
        fiado.setCliente(cliente);
        return iFiadoRepository.save(fiado);
    }

    @Transactional
    public Fiado criarFiadoParaClientePorApelido(String clienteApelido, Fiado fiado){
        Cliente cliente = iClienteRepository.findByApelido(clienteApelido);
        fiado.setCliente(cliente);
        return iFiadoRepository.save(fiado);
    }

    @Transactional(readOnly = true)
    public List<Fiado> listarTodosFiados(){
        return iFiadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Fiado buscarPorId(int id){
        return iFiadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Fiado não encontrado"));
    }

    @Transactional
    public Fiado buscarFiadoPorNomeCliente(String nomeCliente){
        return iFiadoRepository.findByClienteNome(nomeCliente)
                .orElseThrow(() -> new RuntimeException("Fiado não encontrado para o cliente com nome: " + nomeCliente));
    }

    @Transactional
    public Fiado pagamentoPorNome(String nomeCliente, Fiado fiado1){
        Fiado fiado = buscarFiadoPorNomeCliente(nomeCliente);

        float v = fiado.getValor() - fiado1.getValor();
        fiado.setValor(v);

        if(fiado.getValor() < 0 ){
            fiado.setValor(0);
        }

        iFiadoRepository.save(fiado);

        if(fiado.getValor() == 0){
            deletarPorId(fiado.getId());
            System.err.println(fiado.getId());
        }

        return fiado;
    }

    @Transactional
    public Fiado adicionandoValorFiadoPorNome(String nome, Fiado fiado1){
        Fiado fiado = buscarFiadoPorNomeCliente(nome);

        float v = fiado.getValor() + fiado1.getValor();

        fiado.setValor(v);

        return fiado;
    }


    @Transactional
    public void deletarPorId(int id){
        iFiadoRepository.deleteById(id);
    }



}
