package com.spindola.cafeteria.domain.model;

import java.math.BigDecimal;

import com.spindola.cafeteria.domain.model.interfaces.IProduto;

public class ItemPedidoModel {
    private Long id;
    private Integer quantidade;
    private BigDecimal valorTotalItem;
    private IProduto produtoEscolhido;

    public ItemPedidoModel() {
        quantidade = 0;
        valorTotalItem = BigDecimal.ZERO;
        produtoEscolhido = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotalItem() {
        return valorTotalItem;
    }

    public void setValorTotalItem(BigDecimal valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }

    public IProduto getProdutoEscolhido() {
        return produtoEscolhido;
    }

    public void setProdutoEscolhido(IProduto produtoEscolhido) {
        this.produtoEscolhido = produtoEscolhido;
    }

    
    
}
