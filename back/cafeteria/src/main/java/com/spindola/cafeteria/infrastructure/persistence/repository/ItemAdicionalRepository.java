package com.spindola.cafeteria.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spindola.cafeteria.infrastructure.persistence.entity.AdicionalPersistence;

@Repository
public interface ItemAdicionalRepository extends JpaRepository<AdicionalPersistence, Long> {
    public Optional<AdicionalPersistence> findById(Long id);
}
