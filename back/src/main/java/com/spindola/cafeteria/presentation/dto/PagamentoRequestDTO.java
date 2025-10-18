package com.spindola.cafeteria.presentation.dto;

import java.math.BigDecimal;

public record PagamentoRequestDTO(
    Long id,
    BigDecimal valor
) {}
