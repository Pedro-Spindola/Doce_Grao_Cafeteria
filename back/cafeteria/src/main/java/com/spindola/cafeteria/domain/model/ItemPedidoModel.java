package com.spindola.cafeteria.domain.model;

import java.math.BigDecimal;

import com.spindola.cafeteria.domain.model.interfaces.IProduto;

public class ItemPedidoModel {
    private Long id;
    //private Pedido pedido;
    private IProduto cafeBase;
    private BigDecimal valorTotalItem;

    public ItemPedidoModel() {
    }

    public Long getId() {
        return id;
    }

    public IProduto getCafeBase() {
        return cafeBase;
    }

    public BigDecimal getValorTotalItem() {
        return valorTotalItem;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCafeBase(IProduto cafeBase) {
        this.cafeBase = cafeBase;
    }

    public void setValorTotalItem(BigDecimal valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }    
}
