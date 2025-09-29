package com.spindola.cafeteria.domain.decorator;

import java.util.ArrayList;
import java.util.List;

import com.spindola.cafeteria.domain.model.AdicionalModel;
import com.spindola.cafeteria.domain.model.interfaces.IProduto;

public class AdicionalCafe extends Adicional {
    private String nome;
    private double valor;

    public AdicionalCafe(IProduto produto, String nome, double valor) {
        super(produto);
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public List<AdicionalModel> getItemAdicional() {
        List<AdicionalModel> adicionais = new ArrayList<>(produto.getItemAdicional());
        adicionais.add(new AdicionalModel(this.nome, this.valor));
        return adicionais; 
    }

    @Override
    public double getValor() {
        return produto.getValor() + valor;
    }
    
}
