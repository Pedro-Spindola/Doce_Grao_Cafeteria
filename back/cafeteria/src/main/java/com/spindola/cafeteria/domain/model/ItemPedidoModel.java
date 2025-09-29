package com.spindola.cafeteria.domain.model;

import java.util.List;

import com.spindola.cafeteria.domain.model.interfaces.IProduto;

public class ItemPedidoModel {
    private Long id;
    //private Pedido pedido;
    private IProduto cafeBase;
    private double valorTotalItem;

    public ItemPedidoModel() {
    }

    public Long getId() {
        return id;
    }

    public IProduto getCafeBase() {
        return cafeBase;
    }

    public double getValorTotalItem() {
        return valorTotalItem;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCafeBase(IProduto cafeBase) {
        this.cafeBase = cafeBase;
    }

    public void setValorTotalItem(double valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }    
}
