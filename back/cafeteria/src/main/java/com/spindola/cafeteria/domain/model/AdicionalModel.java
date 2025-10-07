package com.spindola.cafeteria.domain.model;

import java.math.BigDecimal;

import com.spindola.cafeteria.domain.model.interfaces.IAdicionais;

public class AdicionalModel implements IAdicionais {
    private Long id;
    private String nome;
    private BigDecimal valor;

    public AdicionalModel() {}
    
    public AdicionalModel(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}