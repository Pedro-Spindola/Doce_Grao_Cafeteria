package com.spindola.cafeteria.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.spindola.cafeteria.domain.model.interfaces.IProduto;

public class CafeModel implements IProduto {
    private Long id;
    private String nome;
    private double valor;
    private List<AdicionalModel> itemAdicional; 

    public CafeModel(){}

    public CafeModel(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
        this.itemAdicional = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public List<AdicionalModel> getItemAdicional() {
        return itemAdicional;
    }

    @Override
    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setItemAdicional(List<AdicionalModel> itemAdicional) {
        this.itemAdicional = itemAdicional;
    }

}
