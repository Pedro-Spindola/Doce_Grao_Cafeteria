package com.spindola.cafeteria.model.cafes;

import java.util.ArrayList;
import java.util.List;

import com.spindola.cafeteria.model.ItemAdicional;
import com.spindola.cafeteria.model.interfaces.IProduto;

public class ColdBrew implements IProduto {
    @Override
    public String getNome() {
        return "Cold Brew";
    }

    @Override
    public List<ItemAdicional> getAdicionais() {
        return new ArrayList<>();
    }

    @Override
    public double getValor() {
        return 15.00;
    }
}
