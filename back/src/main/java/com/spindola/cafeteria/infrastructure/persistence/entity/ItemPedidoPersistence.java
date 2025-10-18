package com.spindola.cafeteria.infrastructure.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ITEM_PEDIDOS")
public class ItemPedidoPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private BigDecimal valorTotalItem;

    @ManyToOne 
    @JoinColumn(name = "cafe_id", nullable = false)
    private CafePersistence cafePedido;

    @ManyToOne 
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoPersistence pedido;

    public ItemPedidoPersistence() {
        valorTotalItem = BigDecimal.ZERO;
    }

    public void valorTotalItemPedido(){
        BigDecimal valorUnitario = cafePedido.getValor();
        BigDecimal quantidadeBD = BigDecimal.valueOf(quantidade);
        valorTotalItem = valorUnitario.multiply(quantidadeBD);
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

    public CafePersistence getCafePedido() {
        return cafePedido;
    }

    public void setCafePedido(CafePersistence cafePedido) {
        this.cafePedido = cafePedido;
    }

    public PedidoPersistence getPedido() {
        return pedido;
    }

    public void setPedido(PedidoPersistence pedido) {
        this.pedido = pedido;
    }
}
