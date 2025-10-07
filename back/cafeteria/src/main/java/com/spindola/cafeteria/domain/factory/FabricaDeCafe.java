package com.spindola.cafeteria.domain.factory;

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

    public IProduto criarCafe(String nome, double valor){
        return new CafeModel(nome, valor);
    }
    
    /*
     * private static FabricaDeCafe instancia;

    private FabricaDeCafe(){}

    public static FabricaDeCafe getInstance(){
        if(instancia == null) {
            instancia = new FabricaDeCafe();
        }
        return instancia;
    }

    public ICafe criarCafe(TipoCafe tipo){
        switch (tipo) {
            case AMERICANO:
                return new Americano();
            case CAPPUCCINO:
                return new Cappuccino();
            case ESPRESSO:
                return new Espresso();
            case FRAPPUCCINO:
                return new Frappuccino();
            case LATTE:
                return new Latte();
            default:
                throw new IllegalArgumentException("Tipo de café inválido: " + tipo);
        }
    }
     */
}
