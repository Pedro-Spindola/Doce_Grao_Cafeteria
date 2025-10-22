package com.spindola.cafeteria.presentation.dto;

import java.math.BigDecimal;

import com.spindola.cafeteria.domain.model.enums.StatusPagamento;
import com.spindola.cafeteria.domain.model.enums.TipoPagamento;

public record PagamentoResponseDTO(
    Long id,
    BigDecimal valor,
    StatusPagamento statusPagamento,
    TipoPagamento tipoPagamento
) {}
