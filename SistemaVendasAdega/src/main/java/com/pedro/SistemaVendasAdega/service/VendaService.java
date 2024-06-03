package com.pedro.SistemaVendasAdega.service;

import com.pedro.SistemaVendasAdega.model.Cliente;
import com.pedro.SistemaVendasAdega.model.ItemVenda;
import com.pedro.SistemaVendasAdega.model.Venda;
import com.pedro.SistemaVendasAdega.repository.IClienteRepository;
import com.pedro.SistemaVendasAdega.repository.IItemVendaRepository;
import com.pedro.SistemaVendasAdega.repository.IProdutoRepository;
import com.pedro.SistemaVendasAdega.repository.IVendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@AllArgsConstructor
@Service
public class VendaService {

    private final IClienteRepository iClienteRepository;
    private final IProdutoRepository iProdutoRepository;
    private final IItemVendaRepository iItemVendaRepository;
    private final IVendaRepository iVendaRepository;

    @Transactional
    public Venda criarVendaPorNome(String nome, List<ItemVenda> itensVendas) {
        Cliente cliente = iClienteRepository.findByNome(nome);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setItensVenda(itensVendas);

        // Salva a venda sem os itens para gerar o ID
        Venda vendaSalva = iVendaRepository.save(venda);

        // Atribui a venda salva a cada ItemVenda e os salva
        for (ItemVenda item : itensVendas) {
            item.setVenda(vendaSalva);
            iItemVendaRepository.save(item);
        }

        // Atualiza a lista de itens na venda salva
        vendaSalva.setItensVenda(itensVendas);

        return vendaSalva;
    }

}
