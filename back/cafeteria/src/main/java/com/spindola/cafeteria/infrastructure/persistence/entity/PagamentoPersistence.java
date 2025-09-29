package com.spindola.cafeteria.infrastructure.persistence.entity;

import java.math.BigDecimal;

import com.spindola.cafeteria.domain.model.enums.StatusPagamento;
import com.spindola.cafeteria.domain.model.enums.TipoPagamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    // RELACIONAMENTO COM PEDIDO (Um para Um)
    @OneToOne
    @JoinColumn(name = "pedido_id", unique = true, nullable = false)
    private PedidoPersistence pedido;

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

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public PedidoPersistence getPedido() {
        return pedido;
    }

    public void setPedido(PedidoPersistence pedido) {
        this.pedido = pedido;
    }
}
