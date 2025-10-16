package com.spindola.cafeteria.domain.model;

import java.math.BigDecimal;

public class PagamentoModel {
    private Long id;
    private BigDecimal valorTotal;

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

    
}
