package com.spindola.cafeteria.application.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.model.PedidoModel;
import com.spindola.cafeteria.infrastructure.persistence.entity.PedidoPersistence;

@Component
public class PedidoMapper {

    public PedidoPersistence toEntity(PedidoModel pedidoModel){
        PedidoPersistence pedido = new PedidoPersistence();
        pedido.setDataHora(pedidoModel.getDataHora());
        pedido.setItens(pedidoModel.getItens());
        pedido.setPagamento(pedidoModel.getPagamento());
        pedido.setSenha(pedidoModel.getSenha());
        pedido.setStatus(pedidoModel.getStatus());
        return null;
    }

}
