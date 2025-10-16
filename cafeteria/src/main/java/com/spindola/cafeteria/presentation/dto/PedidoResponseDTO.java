package com.spindola.cafeteria.presentation.dto;

import java.math.BigDecimal;
import java.util.List;

public record PedidoResponseDTO(
    String senhaRetirada,
    BigDecimal valorTotal,
    List<ItemPedidoResponseDTO> itensComprados
) {}
