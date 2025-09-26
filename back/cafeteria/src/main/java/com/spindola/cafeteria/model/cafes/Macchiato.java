package com.spindola.cafeteria.model.cafes;

import java.util.ArrayList;
import java.util.List;

import com.spindola.cafeteria.model.ItemAdicional;
import com.spindola.cafeteria.model.interfaces.IProduto;

public class Macchiato implements IProduto {
    @Override
    public String getNome() {
        return "Macchiato";
    }

    @Override
    public List<ItemAdicional> getAdicionais() {
        return new ArrayList<>();
    }

    @Override
    public double getValor() {
        return 11.00;
    }
}
