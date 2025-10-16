package com.spindola.cafeteria.presentation.dto;

import java.util.List;

public record PedidoRequestDTO(
    List<ItemPedidoRequestDTO> itens
) {}
