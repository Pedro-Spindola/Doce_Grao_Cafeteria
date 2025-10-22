package com.spindola.cafeteria.infrastructure.persistence.entity;

import java.math.BigDecimal;

import com.spindola.cafeteria.domain.model.enums.StatusPagamento;
import com.spindola.cafeteria.domain.model.enums.TipoPagamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PAGAMENTO")
public class PagamentoPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private StatusPagamento statusPagamento;

    @Column
    private TipoPagamento tipoPagamento;

    @OneToOne
    @JoinColumn(name = "pedido_id", unique = true, nullable = false)
    private PedidoPersistence pedido;

    public PagamentoPersistence() {
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

    public PedidoPersistence getPedido() {
        return pedido;
    }

    public void setPedido(PedidoPersistence pedido) {
        this.pedido = pedido;
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
