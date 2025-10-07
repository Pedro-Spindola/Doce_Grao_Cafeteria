package com.spindola.cafeteria.domain.decorator;

import java.util.List;

import com.spindola.cafeteria.domain.model.AdicionalModel;
import com.spindola.cafeteria.domain.model.interfaces.IProduto;

public abstract class t1 implements IProduto {
    protected IProduto produto;

    public t1(IProduto produto){
       this.produto = produto;
    }

    @Override
    public String getNome() {
        return produto.getNome();
    }

    @Override
    public List<AdicionalModel> getItemAdicional() {
         return produto.getItemAdicional();
    }

    @Override
    public double getValor() {
        return 0;
    }
}
