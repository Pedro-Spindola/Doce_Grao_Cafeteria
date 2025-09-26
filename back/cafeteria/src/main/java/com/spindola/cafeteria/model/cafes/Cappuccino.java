package com.spindola.cafeteria.model.cafes;

import java.util.ArrayList;
import java.util.List;

import com.spindola.cafeteria.model.ItemAdicional;
import com.spindola.cafeteria.model.interfaces.IProduto;

public class Cappuccino implements IProduto {
    @Override
    public String getNome() {
        return "Cappuccino";
    }

    @Override
    public List<ItemAdicional> getAdicionais() {
        return new ArrayList<>();
    }

    @Override
    public double getValor() {
        return 14.00;
    }
}
