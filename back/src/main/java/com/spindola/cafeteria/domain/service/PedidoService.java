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
import com.spindola.cafeteria.domain.model.enums.StatusPagamento;
import com.spindola.cafeteria.domain.model.enums.StatusPedido;
import com.spindola.cafeteria.infrastructure.persistence.entity.CafePersistence;
import com.spindola.cafeteria.infrastructure.persistence.entity.ItemPedidoPersistence;
import com.spindola.cafeteria.infrastructure.persistence.entity.PagamentoPersistence;
import com.spindola.cafeteria.infrastructure.persistence.entity.PedidoPersistence;
import com.spindola.cafeteria.infrastructure.persistence.repository.CafeRepository;
import com.spindola.cafeteria.infrastructure.persistence.repository.PedidoRepository;
import com.spindola.cafeteria.presentation.dto.CafeResponseDTO;
import com.spindola.cafeteria.presentation.dto.ItemPedidoRequestDTO;
import com.spindola.cafeteria.presentation.dto.ItemPedidoResponseDTO;
import com.spindola.cafeteria.presentation.dto.PagamentoRequestDTO;
import com.spindola.cafeteria.presentation.dto.PagamentoResponseDTO;
import com.spindola.cafeteria.presentation.dto.PedidoIdResponseDTO;
import com.spindola.cafeteria.presentation.dto.PedidoRequestDTO;
import com.spindola.cafeteria.presentation.dto.PedidoResponseDTO;
import com.spindola.cafeteria.presentation.dto.PedidoSimplesResponseDTO;

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

    public PedidoIdResponseDTO novoPedido(PedidoRequestDTO pedidoRequestDTO){
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
        pagamentoPersistence.setPedido(pedidoPersistence);
        pagamentoPersistence.setStatusPagamento(StatusPagamento.PENDENTE);
        pagamentoPersistence.setTipoPagamento(null);

        pedidoPersistence.setPagamento(pagamentoPersistence);
        pedidoPersistence.setStatusPedido(StatusPedido.AGUARDANDO_PAGAMENTO);
        
        PedidoPersistence pedidoPersistenceFinal = pedidoRepository.save(pedidoPersistence);

        PedidoIdResponseDTO pedidoId = new PedidoIdResponseDTO(pedidoPersistenceFinal.getId());

        return pedidoId;
    }

    public PedidoResponseDTO aprovarPagamento(PagamentoRequestDTO pag){
        PedidoPersistence pedidoPersistence = pedidoRepository.findById(pag.id_Pedido())
            .orElseThrow(() -> new ProdutoNaoEncontradoException("Id "+ pag.id_Pedido() + " não foi encontrado no banco de dados."));

        PagamentoPersistence pagamentoPersistenceAtualizado = pedidoPersistence.getPagamento();
        pagamentoPersistenceAtualizado.setTipoPagamento(pag.tipoPagamento());
        pagamentoPersistenceAtualizado.setStatusPagamento(StatusPagamento.CONCLUIDO);

        pedidoPersistence.setPagamento(pagamentoPersistenceAtualizado);
        pedidoPersistence.setStatusPedido(StatusPedido.PAGO);

        pedidoRepository.save(pedidoPersistence);

        List<ItemPedidoResponseDTO> itensComprados = new ArrayList<>();
        for(ItemPedidoPersistence item : pedidoPersistence.getItens()){
            CafeResponseDTO cafeResponseDTO = cafeMapper.toResponseDTO(item.getCafePedido());
            itensComprados.add(itemPedidoMapper.toResponseDTO(item, cafeResponseDTO));
        }

        PagamentoResponseDTO pagamentoResponseDTO = pagamentoMapper.toResponseDTO(pagamentoPersistenceAtualizado);
        PedidoResponseDTO pedidoResponseDTO = pedidoMapper.toResponseDTO(pedidoPersistence, pagamentoResponseDTO, itensComprados);

        return pedidoResponseDTO;
    }

    public List<PedidoSimplesResponseDTO> listarPedidosPagos(){
        return pedidoRepository.findByStatusPedido(StatusPedido.PAGO).stream()
                .map(pedidoMapper::toResponseSimplesDTO)
                .toList();
    }

    public List<PedidoSimplesResponseDTO> listarPedidosPronto(){
        return pedidoRepository.findByStatusPedido(StatusPedido.PRONTO).stream()
                .map(pedidoMapper::toResponseSimplesDTO)
                .toList();
    }

    public Boolean seguirStatus(Long idPedido){
        PedidoPersistence pedidoPersistence = pedidoRepository.findById(idPedido)
            .orElseThrow(() -> new ProdutoNaoEncontradoException("Id "+ idPedido + " não foi encontrado no banco de dados."));
        
        if(pedidoPersistence.getStatusPedido() == StatusPedido.PAGO) pedidoPersistence.setStatusPedido(StatusPedido.PRONTO);
        else if(pedidoPersistence.getStatusPedido() == StatusPedido.PRONTO) pedidoPersistence.setStatusPedido(StatusPedido.FINALIZADO);

        pedidoRepository.save(pedidoPersistence);
        return true;
    }
}
