package com.spindola.cafeteria.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spindola.cafeteria.infrastructure.persistence.entity.PedidoPersistence;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoPersistence, Long> {
    
}
