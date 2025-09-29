package com.spindola.cafeteria.domain.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cafeteria.application.mapper.CafeMapper;
import com.spindola.cafeteria.domain.factory.FabricaAdicional;
import com.spindola.cafeteria.domain.factory.FabricaCafe;
import com.spindola.cafeteria.domain.model.AdicionalModel;
import com.spindola.cafeteria.domain.model.ItemPedidoModel;
import com.spindola.cafeteria.domain.model.Pagamento;
import com.spindola.cafeteria.domain.model.PagamentoModel;
import com.spindola.cafeteria.domain.model.PedidoModel;
import com.spindola.cafeteria.domain.model.enums.StatusPagamento;
import com.spindola.cafeteria.domain.model.enums.StatusPedido;
import com.spindola.cafeteria.domain.model.enums.TipoPagamento;
import com.spindola.cafeteria.domain.model.interfaces.IProduto;
import com.spindola.cafeteria.infrastructure.persistence.entity.AdicionalPersistence;
import com.spindola.cafeteria.infrastructure.persistence.entity.CafePersistence;
import com.spindola.cafeteria.infrastructure.persistence.entity.PedidoPersistence;
import com.spindola.cafeteria.infrastructure.persistence.repository.CafeRepository;
import com.spindola.cafeteria.infrastructure.persistence.repository.ItemAdicionalRepository;
import com.spindola.cafeteria.infrastructure.persistence.repository.PedidoRepository;
import com.spindola.cafeteria.presentation.dto.ItemPedidoRequestDTO;
import com.spindola.cafeteria.presentation.dto.PedidoRequestDTO;
import com.spindola.cafeteria.presentation.dto.PedidoResponseDTO;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    CafeRepository cafeRepository;

    @Autowired
    ItemAdicionalRepository adicionalRepository;

    @Autowired
    FabricaCafe fabricaCafe;

    @Autowired
    FabricaAdicional fabricaAdicional;

    @Autowired
    CafeMapper cafeMapper;
    
    public PedidoResponseDTO novoPedido(PedidoRequestDTO pedidoRequestDTO) {
        PedidoModel novoPedido = new PedidoModel();
        PagamentoModel pagamento = new PagamentoModel();
        pagamento.setTipoPagamento(pedidoRequestDTO.tipoPagamento());
        novoPedido.setPagamento(pagamento);

        List<ItemPedidoModel> novaListitemPedido = new ArrayList<>();

        for (ItemPedidoRequestDTO listPedidoRequestDTO : pedidoRequestDTO.items()) {
            ItemPedidoModel itemPedido = new ItemPedidoModel();
            CafePersistence cafePersistence = cafeRepository.findById(listPedidoRequestDTO.idCafe()).get();
            itemPedido.setCafeBase(fabricaCafe.criarCafe(cafePersistence.getNome(), cafePersistence.getValor().doubleValue()));

            for (Long k : listPedidoRequestDTO.idsAdicionais()) {
                AdicionalPersistence adicionalPersistence = adicionalRepository.findById(k).get();
                itemPedido.setCafeBase(fabricaAdicional.criarAdicional(itemPedido.getCafeBase(), adicionalPersistence.getNome(),  adicionalPersistence.getValor().doubleValue()));
            }
            novaListitemPedido.add(itemPedido);
        }
        novoPedido.setItens(novaListitemPedido);
        novoPedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        novoPedido.setSenha("A-77");
        novoPedido.setDataHora(LocalDateTime.now());

        // MAPPER

        pedidoRepository.save(novoPedido);

        return null;
    }

    
}
