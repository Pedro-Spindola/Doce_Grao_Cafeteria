package com.spindola.cafeteria.domain.model.interfaces;

import java.math.BigDecimal;
import java.util.List;

public interface IProduto {
    String getNome();
    List<IAdicionais> getItemAdicional();
    BigDecimal getValor();
    void novoAdicional(IAdicionais adicional);
}
