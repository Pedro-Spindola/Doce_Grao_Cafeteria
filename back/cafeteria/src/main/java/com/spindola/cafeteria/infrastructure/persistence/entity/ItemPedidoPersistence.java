package com.spindola.cafeteria.infrastructure.persistence.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ITEM_PEDIDOS")
public class ItemPedidoPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // CHAVE ESTRANGEIRA 1: Aponta para o tipo de Café no Catálogo (ManyToOne)
    @ManyToOne 
    @JoinColumn(name = "cafe_id", nullable = false)
    private CafePersistence itensDePedido; // O nome 'cafeBase' é usado no mappedBy de CafePersistence

    // CHAVE ESTRANGEIRA 2: Aponta para o Pedido (ManyToOne) - Assumindo que PedidoPersistence existe
    @ManyToOne 
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoPersistence pedido;
    
    // CHAVE INTERNA: Lista de Adicionais Desejados (@OneToMany)
    // MappedBy aponta para o campo 'itemPedido' na classe ItemAdicionalPedido.
    @OneToMany(mappedBy = "itemPedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemAdicionalPedido> adicionais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CafePersistence getItensDePedido() {
        return itensDePedido;
    }

    public void setItensDePedido(CafePersistence itensDePedido) {
        this.itensDePedido = itensDePedido;
    }

    public PedidoPersistence getPedido() {
        return pedido;
    }

    public void setPedido(PedidoPersistence pedido) {
        this.pedido = pedido;
    }

    public List<ItemAdicionalPedido> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(List<ItemAdicionalPedido> adicionais) {
        this.adicionais = adicionais;
    } 

    /*
    @Column(nullable = false)
    private double valorTotalItem; // Valor final: (Café + Adicionais)*/

    
}
