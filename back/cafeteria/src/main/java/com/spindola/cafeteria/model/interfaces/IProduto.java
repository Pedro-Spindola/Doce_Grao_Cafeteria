package com.spindola.cafeteria.model.interfaces;

import java.util.List;

import com.spindola.cafeteria.model.ItemAdicional;

public interface IProduto {
    String getNome();
    List<ItemAdicional> getAdicionais();
    double getValor();
}
