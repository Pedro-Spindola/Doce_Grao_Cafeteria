package com.spindola.cafeteria.presentation.dto;

import java.util.List;

public record ItemPedidoRequestDTO(
    Long idCafe,
    List<Long> idsAdicionais
) {}