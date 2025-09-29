package com.spindola.cafeteria.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import com.spindola.cafeteria.domain.model.enums.StatusPedido;

public class PedidoModel {
    private Long id;
    private String senha;
    private StatusPedido status;
    private PagamentoModel pagamento;
    private LocalDateTime dataHora;
    private List<ItemPedidoModel> itens;
    
    public PedidoModel() {
    }

    public Long getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public PagamentoModel getPagamento() {
        return pagamento;
    }

    public List<ItemPedidoModel> getItens() {
        return itens;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setPagamento(PagamentoModel pagamento) {
        this.pagamento = pagamento;
    }

    public void setItens(List<ItemPedidoModel> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
