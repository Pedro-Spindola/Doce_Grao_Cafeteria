package com.spindola.cafeteria.application.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.model.AdicionalModel;
import com.spindola.cafeteria.infrastructure.persistence.entity.AdicionalPersistence;
import com.spindola.cafeteria.presentation.dto.AdicionalRequestDTO;
import com.spindola.cafeteria.presentation.dto.AdicionalResponseDTO;

@Component
public class AdicionalMapper {
    
    public AdicionalResponseDTO toResponseDTO(AdicionalPersistence adicional){
        return new AdicionalResponseDTO(
            adicional.getId(),
            adicional.getNome(),
            adicional.getValor().doubleValue()
        );
    }

    public AdicionalResponseDTO toResponseDTO(AdicionalModel adicional){
        return new AdicionalResponseDTO(
            adicional.getId(),
            adicional.getNome(),
            adicional.getValor()
        );
    }

    public AdicionalPersistence toEntity(AdicionalRequestDTO dto){
        AdicionalPersistence adicional = new AdicionalPersistence();
        adicional.setNome(dto.nome());
        adicional.setValor(BigDecimal.valueOf(dto.valor()));
        return adicional;
    }

    public AdicionalPersistence toEntity(AdicionalModel adicionalModel){
        AdicionalPersistence adicional = new AdicionalPersistence();
        adicional.setNome(adicionalModel.getNome());
        adicional.setValor(BigDecimal.valueOf(adicionalModel.getValor()));
        return adicional;
    }

    public AdicionalModel toModel(AdicionalRequestDTO dto){
        AdicionalModel adicional = new AdicionalModel();
        adicional.setNome(dto.nome());
        adicional.setValor(dto.valor());
        return adicional;
    }
}
