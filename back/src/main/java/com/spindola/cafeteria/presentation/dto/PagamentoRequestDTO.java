package com.spindola.cafeteria.presentation.dto;

import com.spindola.cafeteria.domain.model.enums.TipoPagamento;

public record PagamentoRequestDTO(
    Long id_Pedido,
    TipoPagamento tipoPagamento
) {}
