package com.spindola.cafeteria.domain.model;

import java.util.List;

import com.spindola.cafeteria.domain.model.enums.StatusPedido;

public class PedidoModel {
    private Long id;
    private String senha;
    private PagamentoModel pagamento;
    private List<ItemPedidoModel> itens;
    private StatusPedido statusPedido;

    public PedidoModel() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public PagamentoModel getPagamento() {
        return pagamento;
    }
    public void setPagamento(PagamentoModel pagamento) {
        this.pagamento = pagamento;
    }
    public List<ItemPedidoModel> getItens() {
        return itens;
    }
    public void setItens(List<ItemPedidoModel> itens) {
        this.itens = itens;
    }
    public StatusPedido getStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
    
}
