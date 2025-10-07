package com.spindola.cafeteria.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.spindola.cafeteria.domain.model.interfaces.IAdicionais;
import com.spindola.cafeteria.domain.model.interfaces.IProduto;

public class CafeModel implements IProduto {
    private Long id;
    private String nome;
    private BigDecimal valor;
    private List<IAdicionais> itemAdicional; 

    public CafeModel(){}

    public CafeModel(String nome, BigDecimal valor) {
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
    public List<IAdicionais> getItemAdicional() {
        return itemAdicional;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setItemAdicional(List<IAdicionais> itemAdicional) {
        this.itemAdicional = itemAdicional;
    }

    @Override
    public void novoAdicional(IAdicionais adicional){
        itemAdicional.add(adicional);
    }
    

}
