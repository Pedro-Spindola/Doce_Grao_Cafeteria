package com.spindola.cafeteria.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.cafeteria.domain.service.PedidoService;
import com.spindola.cafeteria.presentation.dto.PagamentoRequestDTO;
import com.spindola.cafeteria.presentation.dto.PedidoIdResponseDTO;
import com.spindola.cafeteria.presentation.dto.PedidoRequestDTO;
import com.spindola.cafeteria.presentation.dto.PedidoResponseDTO;   

@RestController
@RequestMapping("api/v1/pedido")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @PostMapping
    public PedidoIdResponseDTO fazerNovoPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO){
        return pedidoService.novoPedido(pedidoRequestDTO);
    }

    @PutMapping(value = "/pagamento")
    public PedidoResponseDTO aprovarPagamento(@RequestBody PagamentoRequestDTO pagamentoRequestDTO){
        return pedidoService.aprovarPagamento(pagamentoRequestDTO);
    }
}
