package com.spindola.cafeteria.presentation.dto;

import java.math.BigDecimal;

public record PagamentoResponseDTO(
    Long id,
    BigDecimal valor
) {}
