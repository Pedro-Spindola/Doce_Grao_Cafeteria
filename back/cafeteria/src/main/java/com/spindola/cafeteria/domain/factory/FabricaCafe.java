package com.spindola.cafeteria.domain.factory;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.model.CafeModel;
import com.spindola.cafeteria.domain.model.interfaces.IProduto;

@Component
public class FabricaCafe {
    private static FabricaCafe instancia;

    private FabricaCafe(){}

    public static FabricaCafe getInstance(){
        if(instancia == null) {
            instancia = new FabricaCafe();
        }
        return instancia;
    }

    public IProduto criarCafe(String nome, double valor){
        return new CafeModel(nome, valor);
    }
    
}
