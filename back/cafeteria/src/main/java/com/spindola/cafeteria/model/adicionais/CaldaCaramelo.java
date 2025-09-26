package com.spindola.cafeteria.model.adicionais;

import java.util.ArrayList;
import java.util.List;

import com.spindola.cafeteria.model.Adicional;
import com.spindola.cafeteria.model.ItemAdicional;
import com.spindola.cafeteria.model.interfaces.IProduto;

public class CaldaCaramelo extends Adicional {
    public CaldaCaramelo(IProduto produto) {
        super(produto);
    }

    @Override
    public List<ItemAdicional> getAdicionais() {
        List<ItemAdicional> adicionais = new ArrayList<>(produto.getAdicionais());
        adicionais.add(new ItemAdicional("Calda Caramelo", 3.00));
        return adicionais;
    }

    @Override
    public double getValor() {
        return produto.getValor() + 3.00;
    }
}
