package com.spindola.cafeteria.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spindola.cafeteria.domain.model.enums.StatusPedido;
import com.spindola.cafeteria.infrastructure.persistence.entity.PedidoPersistence;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoPersistence, Long> {
    List<PedidoPersistence> findByStatusPedido(StatusPedido statusPedido);
}
