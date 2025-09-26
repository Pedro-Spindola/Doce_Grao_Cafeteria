package com.spindola.cafeteria.model;

public class ItemAdicional {
    private String nome;
    private double valor;

    public ItemAdicional(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
