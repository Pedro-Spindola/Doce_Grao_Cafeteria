package com.spindola.cafeteria.presentation.dto;

import java.math.BigDecimal;

public record CafeRequestDTO(
    Long id,
    String nome,
    BigDecimal valor
) {}
