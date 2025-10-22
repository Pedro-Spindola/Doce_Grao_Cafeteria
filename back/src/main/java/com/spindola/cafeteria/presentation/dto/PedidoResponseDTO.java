package com.spindola.cafeteria.presentation.dto;

import java.util.List;

import com.spindola.cafeteria.domain.model.enums.StatusPedido;

public record PedidoResponseDTO(
    String senhaRetirada,
    StatusPedido statusPedido,
    PagamentoResponseDTO pagamento,
    List<ItemPedidoResponseDTO> itensComprados
) {}
