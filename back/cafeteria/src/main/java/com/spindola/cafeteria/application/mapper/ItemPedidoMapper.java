package com.spindola.cafeteria.application.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.model.ItemPedidoModel;
import com.spindola.cafeteria.infrastructure.persistence.entity.ItemPedidoPersistence;

@Component
public class ItemPedidoMapper {
    @Autowired
    CafeMapper cafeMapper;

    public ItemPedidoPersistence toEntity(ItemPedidoModel itemModel){
        ItemPedidoPersistence item = new ItemPedidoPersistence();
        item.setItensDePedido(cafeMapper.toEntity(itemModel.getCafeBase()));
        item.setPedido(null);
        return null;
    }
}
