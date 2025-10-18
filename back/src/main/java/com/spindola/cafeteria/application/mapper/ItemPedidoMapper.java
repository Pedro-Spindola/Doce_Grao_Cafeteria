package com.spindola.cafeteria.application.mapper;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.model.ItemPedidoModel;
import com.spindola.cafeteria.infrastructure.persistence.entity.CafePersistence;
import com.spindola.cafeteria.infrastructure.persistence.entity.ItemPedidoPersistence;
import com.spindola.cafeteria.presentation.dto.CafeResponseDTO;
import com.spindola.cafeteria.presentation.dto.ItemPedidoRequestDTO;
import com.spindola.cafeteria.presentation.dto.ItemPedidoResponseDTO;

@Component
public class ItemPedidoMapper {
    
    public ItemPedidoResponseDTO toResponseDTO(ItemPedidoModel itemPedidoModel){
        return null;
    }

    public ItemPedidoResponseDTO toResponseDTO(ItemPedidoPersistence itemPedidoPersistence, CafeResponseDTO cafeResponseDTO){
        ItemPedidoResponseDTO itemPedidoResponseDTO = new ItemPedidoResponseDTO(
            itemPedidoPersistence.getQuantidade(),
            cafeResponseDTO,
            itemPedidoPersistence.getValorTotalItem()
        );
        return itemPedidoResponseDTO;
    }

    public ItemPedidoPersistence toEntity(ItemPedidoRequestDTO dto, CafePersistence cafe){
        ItemPedidoPersistence itemPedidoPersistence = new ItemPedidoPersistence();
        itemPedidoPersistence.setQuantidade(dto.quantidade());
        itemPedidoPersistence.setCafePedido(cafe);
        return itemPedidoPersistence;
    }

    public ItemPedidoPersistence toEntity(ItemPedidoModel itemPedidoModel){
        return null;
    }

    public ItemPedidoModel toModel(ItemPedidoRequestDTO dto){
        return null;
    }

    public ItemPedidoModel toModel(ItemPedidoPersistence itemPedidoPersistence){
        return null;
    }
}
