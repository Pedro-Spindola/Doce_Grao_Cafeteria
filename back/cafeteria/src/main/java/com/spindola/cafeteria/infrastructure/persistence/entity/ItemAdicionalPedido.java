package com.spindola.cafeteria.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ITEM_ADICIONAL_PEDIDO")
public class ItemAdicionalPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // CHAVE ESTRANGEIRA 1: Aponta para a linha do pedido (O Proprietário da FK)
    @ManyToOne
    @JoinColumn(name = "item_pedido_id", nullable = false)
    private ItemPedidoPersistence itemPedido; 
    
    // CHAVE ESTRANGEIRA 2: Aponta para o Catálogo de Adicionais
    @ManyToOne 
    @JoinColumn(name = "adicional_id", nullable = false)
    private AdicionalPersistence adicionalCatalogo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemPedidoPersistence getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedidoPersistence itemPedido) {
        this.itemPedido = itemPedido;
    }

    public AdicionalPersistence getAdicionalCatalogo() {
        return adicionalCatalogo;
    }

    public void setAdicionalCatalogo(AdicionalPersistence adicionalCatalogo) {
        this.adicionalCatalogo = adicionalCatalogo;
    } 

    
}