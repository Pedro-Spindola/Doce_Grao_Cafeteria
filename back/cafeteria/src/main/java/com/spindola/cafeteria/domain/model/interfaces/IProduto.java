package com.spindola.cafeteria.domain.model.interfaces;

import java.util.List;

import com.spindola.cafeteria.domain.model.AdicionalModel;

public interface IProduto {
    String getNome();
    List<AdicionalModel> getItemAdicional();
    double getValor();
}
