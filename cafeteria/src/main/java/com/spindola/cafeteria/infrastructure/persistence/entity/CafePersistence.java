package com.spindola.cafeteria.infrastructure.persistence.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CAFE")
public class CafePersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private BigDecimal valor;
    @OneToMany(mappedBy = "cafePedido", fetch = FetchType.LAZY) 
    private List<ItemPedidoPersistence> itensPedidos;

    public CafePersistence(){}

    public CafePersistence(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ItemPedidoPersistence> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedidoPersistence> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }
}
