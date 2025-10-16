package com.spindola.cafeteria.domain.model;

import java.math.BigDecimal;

import com.spindola.cafeteria.domain.model.interfaces.IProduto;

public class CafeModel implements IProduto {
    private Long id;
    private String nome;
    private BigDecimal valor;

    public CafeModel() {
    }

    public CafeModel(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
