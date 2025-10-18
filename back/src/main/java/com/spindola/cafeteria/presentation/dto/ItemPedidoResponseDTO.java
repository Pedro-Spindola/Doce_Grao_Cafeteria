package com.spindola.cafeteria.presentation.dto;

import java.math.BigDecimal;

public record ItemPedidoResponseDTO(
    Integer quantidade,
    CafeResponseDTO cafe,
    BigDecimal valorTotalItem
) {}
