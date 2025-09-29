package com.spindola.cafeteria.presentation.dto;

import java.math.BigDecimal;
import java.util.List;

public record ItemComprovanteResponseDTO(
    String nomeCafe,
    BigDecimal valorItem,
    List<String> adicionais
) {}
