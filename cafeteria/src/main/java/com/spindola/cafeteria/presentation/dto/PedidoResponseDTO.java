package com.spindola.cafeteria.presentation.dto;

import java.util.List;

public record PedidoResponseDTO(
    String senhaRetirada,
    PagamentoResponseDTO pagamento,
    List<ItemPedidoResponseDTO> itensComprados
) {}
