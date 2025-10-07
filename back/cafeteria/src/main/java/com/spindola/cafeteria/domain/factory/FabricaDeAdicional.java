package com.spindola.cafeteria.domain.factory;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.model.AdicionalModel;
import com.spindola.cafeteria.domain.model.interfaces.IAdicionais;

@Component
public class FabricaDeAdicional {
    private static FabricaDeAdicional instancia;

    private FabricaDeAdicional(){}

    public static FabricaDeAdicional getInstance(){
        if(instancia == null) {
            instancia = new FabricaDeAdicional();
        }
        return instancia;
    }

    public IAdicionais criarAdicional(String nome, BigDecimal valor){
        return new AdicionalModel(nome, valor); 
    }
    
}
