package com.spindola.cafeteria.domain.factory;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.decorator.t2;
import com.spindola.cafeteria.domain.model.interfaces.IProduto;

@Component
public class t3 {
    private static t3 instancia;

    private t3(){}

    public static t3 getInstance(){
        if(instancia == null) {
            instancia = new t3();
        }
        return instancia;
    }

    public IProduto criarAdicional(IProduto cafe, String nome, double valor){
        return new t2(cafe, nome, valor); 
    }
    
}
