package com.spindola.cafeteria.domain.model;

import java.math.BigDecimal;

import com.spindola.cafeteria.domain.model.enums.StatusPagamento;
import com.spindola.cafeteria.domain.model.enums.TipoPagamento;

public class PagamentoModel {
    private Long id;
    private BigDecimal valorTotal;
    private StatusPagamento statusPagamento;
    private TipoPagamento tipoPagamento;

    public PagamentoModel() {
        valorTotal = BigDecimal.ZERO;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }
    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }
    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
