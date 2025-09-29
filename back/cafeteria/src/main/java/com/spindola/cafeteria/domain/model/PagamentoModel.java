package com.spindola.cafeteria.domain.model;

import com.spindola.cafeteria.domain.model.enums.StatusPagamento;
import com.spindola.cafeteria.domain.model.enums.TipoPagamento;

public class PagamentoModel {
    private Long id;
    private double valorTotal;
    private TipoPagamento tipoPagamento;
    private StatusPagamento status;
    private PedidoModel pedido;

    public PagamentoModel() {
    }

    public Long getId() {
        return id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

}
