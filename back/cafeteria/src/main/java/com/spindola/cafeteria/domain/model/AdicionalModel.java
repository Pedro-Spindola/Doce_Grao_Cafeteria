package com.spindola.cafeteria.domain.model;

public class AdicionalModel {
    private Long id;
    private String nome;
    private double valor;

    public AdicionalModel() {}
    
    public AdicionalModel(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}