package com.spindola.cafeteria.application.mapper;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.model.CafeModel;
import com.spindola.cafeteria.domain.model.interfaces.IProduto;
import com.spindola.cafeteria.infrastructure.persistence.entity.CafePersistence;
import com.spindola.cafeteria.presentation.dto.CafeRequestDTO;
import com.spindola.cafeteria.presentation.dto.CafeResponseDTO;

@Component
public class CafeMapper {
    @Autowired
    AdicionalMapper adicionalMapper;
    @Autowired
    ItemPedidoMapper itemPedidoMapper;

    public CafeResponseDTO toResponseDTO(CafePersistence cafe){
        return new CafeResponseDTO(
            cafe.getId(),
            cafe.getNome(),
            cafe.getValor().doubleValue()
        );
    }

    public CafeResponseDTO toResponseDTO(CafeModel cafe){
        return new CafeResponseDTO(
            cafe.getId(),
            cafe.getNome(),
            cafe.getValor()
        );
    }

    public CafePersistence toEntity(CafeRequestDTO dto){
        CafePersistence cafe = new CafePersistence();
        cafe.setNome(dto.nome());
        cafe.setValor(BigDecimal.valueOf(dto.valor()));
        return cafe;
    }

    public CafePersistence toEntity(IProduto cafeModel){
        CafePersistence cafe = new CafePersistence();
        cafe.setNome(cafeModel.getNome());
        cafe.setValor(BigDecimal.valueOf(cafeModel.getValor()));
        return cafe;
    }

    public CafeModel toModel(CafeRequestDTO dto){
        CafeModel cafe = new CafeModel();
        cafe.setNome(dto.nome());
        cafe.setValor(dto.valor());
        return cafe;
    }
}
