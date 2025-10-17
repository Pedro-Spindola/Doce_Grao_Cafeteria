package com.spindola.cafeteria.domain.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cafeteria.application.mapper.CafeMapper;
import com.spindola.cafeteria.application.mapper.ItemPedidoMapper;
import com.spindola.cafeteria.application.mapper.PagamentoMapper;
import com.spindola.cafeteria.application.mapper.PedidoMapper;
import com.spindola.cafeteria.domain.exceptions.CampoObrigatorioNuloException;
import com.spindola.cafeteria.domain.exceptions.ProdutoNaoEncontradoException;
import com.spindola.cafeteria.infrastructure.persistence.entity.CafePersistence;
import com.spindola.cafeteria.infrastructure.persistence.entity.ItemPedidoPersistence;
import com.spindola.cafeteria.infrastructure.persistence.entity.PagamentoPersistence;
import com.spindola.cafeteria.infrastructure.persistence.entity.PedidoPersistence;
import com.spindola.cafeteria.infrastructure.persistence.repository.CafeRepository;
import com.spindola.cafeteria.infrastructure.persistence.repository.PedidoRepository;
import com.spindola.cafeteria.presentation.dto.CafeResponseDTO;
import com.spindola.cafeteria.presentation.dto.ItemPedidoRequestDTO;
import com.spindola.cafeteria.presentation.dto.ItemPedidoResponseDTO;
import com.spindola.cafeteria.presentation.dto.PagamentoResponseDTO;
import com.spindola.cafeteria.presentation.dto.PedidoRequestDTO;
import com.spindola.cafeteria.presentation.dto.PedidoResponseDTO;

@Service
public class PedidoService {
    
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    CafeRepository cafeRepository;

    @Autowired
    ItemPedidoMapper itemPedidoMapper;

    @Autowired
    PedidoMapper pedidoMapper;
    
    @Autowired
    CafeMapper cafeMapper;

    @Autowired
    PagamentoMapper pagamentoMapper;

    @Autowired
    GeradorDeSenhaPedidoService geradoSenhaService;

    public PedidoResponseDTO novoPedido(PedidoRequestDTO pedidoRequestDTO){
        PedidoPersistence pedidoPersistence = new PedidoPersistence();
        pedidoPersistence.setSenha(geradoSenhaService.gerarNovaSenha());

        PagamentoPersistence pagamentoPersistence = new PagamentoPersistence();
        BigDecimal valorFinal = BigDecimal.ZERO;

        if(pedidoRequestDTO.itens().isEmpty()) throw new CampoObrigatorioNuloException("Lista Item de Pedidos");

        for (ItemPedidoRequestDTO item : pedidoRequestDTO.itens()){
            CafePersistence cafePersistence = cafeRepository.findById(item.idCafe())
                .orElseThrow(() -> new ProdutoNaoEncontradoException("O café de ID " + item.idCafe() + " não foi encontrado no catálogo."));
            
            if(item.quantidade() <= 0) throw new CampoObrigatorioNuloException("Quantidade");

            ItemPedidoPersistence itemPedidoPersistence = itemPedidoMapper.toEntity(item, cafePersistence);
            itemPedidoPersistence.setPedido(pedidoPersistence);
            itemPedidoPersistence.valorTotalItemPedido();

            pedidoPersistence.getItens().add(itemPedidoPersistence);

            valorFinal = valorFinal.add(itemPedidoPersistence.getValorTotalItem());
        }

        pagamentoPersistence.setValorTotal(valorFinal);
        pedidoPersistence.setPagamento(pagamentoPersistence);
        pagamentoPersistence.setPedido(pedidoPersistence);
        
        pedidoRepository.save(pedidoPersistence);

        List<ItemPedidoResponseDTO> itensComprados = new ArrayList<>();
        for(ItemPedidoPersistence item : pedidoPersistence.getItens()){
            CafeResponseDTO cafeResponseDTO = cafeMapper.toResponseDTO(item.getCafePedido());
            itensComprados.add(itemPedidoMapper.toResponseDTO(item, cafeResponseDTO));
        }

        PagamentoResponseDTO pagamentoResponseDTO = pagamentoMapper.toResponseDTO(pagamentoPersistence);

        PedidoResponseDTO pedidoResponseDTO = pedidoMapper.toResponseDTO(pedidoPersistence, pagamentoResponseDTO, itensComprados);
        return pedidoResponseDTO;
    }
}
