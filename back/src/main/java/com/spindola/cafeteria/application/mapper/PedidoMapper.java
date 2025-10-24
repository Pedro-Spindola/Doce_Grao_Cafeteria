package com.spindola.cafeteria.application.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.model.PedidoModel;
import com.spindola.cafeteria.infrastructure.persistence.entity.PedidoPersistence;
import com.spindola.cafeteria.presentation.dto.ItemPedidoResponseDTO;
import com.spindola.cafeteria.presentation.dto.PagamentoResponseDTO;
import com.spindola.cafeteria.presentation.dto.PedidoRequestDTO;
import com.spindola.cafeteria.presentation.dto.PedidoResponseDTO;
import com.spindola.cafeteria.presentation.dto.PedidoSimplesResponseDTO;

@Component
public class PedidoMapper {
    public PedidoResponseDTO toResponseDTO(PedidoModel pedidoModel){
        return null;
    }

    public PedidoResponseDTO toResponseDTO(PedidoPersistence pedidoPersistence, PagamentoResponseDTO pagamentoResponseDTO, List<ItemPedidoResponseDTO> itemPedidoResponseDTO){
        return new PedidoResponseDTO(
            pedidoPersistence.getSenha(),
            pedidoPersistence.getStatusPedido(),
            pagamentoResponseDTO,
            itemPedidoResponseDTO
        );
    }

     public PedidoSimplesResponseDTO toResponseSimplesDTO(PedidoPersistence pedidoPersistence){
        return new PedidoSimplesResponseDTO(
            pedidoPersistence.getId(),
            pedidoPersistence.getSenha()
        );
     }

    public PedidoPersistence toEntity(PedidoRequestDTO dto){
        return null;
    }

    public PedidoPersistence toEntity(PedidoModel pedidoModel){
        return null;
    }

    public PedidoModel toModel(PedidoRequestDTO dto){
        return null;
    }

    public PedidoModel toModel(PedidoPersistence pedidoPersistence){
        return null;
    }
}
