package com.spindola.cafeteria.domain.factory;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.model.CafeModel;
import com.spindola.cafeteria.domain.model.interfaces.IProduto;

@Component
public class FabricaDeCafe {
    private static FabricaDeCafe instancia;

    private FabricaDeCafe(){}

    public static FabricaDeCafe getInstance(){
        if(instancia == null) {
            instancia = new FabricaDeCafe();
        }
        return instancia;
    }

    public IProduto criarCafe(String nome, BigDecimal valor){
        return new CafeModel(nome, valor);
    }
}
