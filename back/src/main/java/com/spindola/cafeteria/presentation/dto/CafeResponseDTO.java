package com.spindola.cafeteria.presentation.dto;

import java.math.BigDecimal;

public record CafeResponseDTO(
    Long id,
    String nome,
    String descrica,
    BigDecimal valor
) {}
