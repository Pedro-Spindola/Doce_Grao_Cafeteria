package com.spindola.cafeteria.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
import com.spindola.cafeteria.presentation.dto.PedidoSimplesResponseDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/pedido")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @GetMapping("/listarPagos")
    public List<PedidoSimplesResponseDTO> listarPedidosPagos() {
        return pedidoService.listarPedidosPagos();
    }

    @GetMapping("/listarRetirada")
    public List<PedidoSimplesResponseDTO> listarPedidosPronto() {
        return pedidoService.listarPedidosPronto();
    }
    
    @PostMapping
    public PedidoIdResponseDTO fazerNovoPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO){
        return pedidoService.novoPedido(pedidoRequestDTO);
    }

    @PutMapping(value = "/pagamento")
    public PedidoResponseDTO aprovarPagamento(@RequestBody PagamentoRequestDTO pagamentoRequestDTO){
        PedidoResponseDTO pedido = pedidoService.aprovarPagamento(pagamentoRequestDTO);
        messagingTemplate.convertAndSend("/topic/pedidos", pedido);
        return pedido;
    }

    @PutMapping(value = "/status/{id}")
    public Boolean seguirProximoStatus(@PathVariable Long id) {
        Boolean atualizado = pedidoService.seguirStatus(id);

        if (atualizado) {
            messagingTemplate.convertAndSend("/topic/pedidos-status", id);
        }

        return atualizado;
    }
}
