package com.spindola.cafeteria.application.mapper;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.infrastructure.persistence.entity.PagamentoPersistence;
import com.spindola.cafeteria.presentation.dto.PagamentoResponseDTO;

@Component
public class PagamentoMapper {
    
    public PagamentoResponseDTO toResponseDTO(PagamentoPersistence pagamentoPersistence){
        PagamentoResponseDTO pagamentoResponseDTO = new PagamentoResponseDTO(
            pagamentoPersistence.getId(),
            pagamentoPersistence.getValorTotal()
        );
        return pagamentoResponseDTO;
    }

}
