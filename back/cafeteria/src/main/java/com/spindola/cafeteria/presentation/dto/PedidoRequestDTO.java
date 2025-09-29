package com.spindola.cafeteria.presentation.dto;

import java.util.List;

import com.spindola.cafeteria.domain.model.enums.TipoPagamento;

public record PedidoRequestDTO(
    List<ItemPedidoRequestDTO> items,
    TipoPagamento tipoPagamento
) {}
