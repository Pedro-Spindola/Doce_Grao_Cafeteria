package com.spindola.cafeteria.model;

import java.util.List;
import com.spindola.cafeteria.model.interfaces.IProduto;

public abstract class Adicional implements IProduto {
    protected IProduto produto;

    public Adicional(IProduto produto){
       this.produto = produto;
    }

    @Override
    public String getNome() {
        return produto.getNome();
    }

    @Override
    public List<ItemAdicional> getAdicionais() {
        return produto.getAdicionais();
    }

    @Override
    public double getValor() {
        return 0;
    }
}
