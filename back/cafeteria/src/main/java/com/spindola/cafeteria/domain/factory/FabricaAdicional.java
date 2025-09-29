package com.spindola.cafeteria.domain.factory;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.decorator.AdicionalCafe;
import com.spindola.cafeteria.domain.model.interfaces.IProduto;

@Component
public class FabricaAdicional {
    private static FabricaAdicional instancia;

    private FabricaAdicional(){}

    public static FabricaAdicional getInstance(){
        if(instancia == null) {
            instancia = new FabricaAdicional();
        }
        return instancia;
    }

    public IProduto criarAdicional(IProduto cafe, String nome, double valor){
        return new AdicionalCafe(cafe, nome, valor); 
    }
    
}
