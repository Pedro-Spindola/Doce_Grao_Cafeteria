package com.spindola.cafeteria.application.mapper;

import org.springframework.stereotype.Component;

import com.spindola.cafeteria.domain.model.CafeModel;
import com.spindola.cafeteria.infrastructure.persistence.entity.CafePersistence;
import com.spindola.cafeteria.presentation.dto.CafeRequestDTO;
import com.spindola.cafeteria.presentation.dto.CafeResponseDTO;

@Component
public class CafeMapper {

    public CafeResponseDTO toResponseDTO(CafePersistence cafePersistence){
        return new CafeResponseDTO(
            cafePersistence.getId(),
            cafePersistence.getNome(),
            cafePersistence.getDescricao(),
            cafePersistence.getValor()
        );
    }

    public CafeResponseDTO toResponseDTO(CafeModel cafeModel){
        return new CafeResponseDTO(
            cafeModel.getId(),
            cafeModel.getNome(),
            cafeModel.getDescricao(),
            cafeModel.getValor()
        );
    }

    public  CafePersistence toEntity(CafeRequestDTO dto){
        CafePersistence cafePersistence = new CafePersistence();
        cafePersistence.setId(dto.id());
        cafePersistence.setNome(dto.nome());
        cafePersistence.setDescricao(dto.descrica());
        cafePersistence.setValor(dto.valor());
        return cafePersistence;
    }

    public CafePersistence toEntity(CafeModel cafeModel){
        CafePersistence cafePersistence = new CafePersistence();
        cafePersistence.setId(cafeModel.getId());
        cafePersistence.setNome(cafeModel.getNome());
        cafePersistence.setDescricao(cafeModel.getDescricao());
        cafePersistence.setValor(cafeModel.getValor());
        return cafePersistence;
    }

    public CafeModel toModel(CafeRequestDTO dto){
        CafeModel cafeModel = new CafeModel();
        cafeModel.setId(dto.id());
        cafeModel.setNome(dto.nome());
        cafeModel.setDescricao(dto.descrica());
        cafeModel.setValor(dto.valor());
        return cafeModel;
    }

    public CafeModel toModel(CafePersistence cafePersistence){
        CafeModel cafeModel = new CafeModel();
        cafeModel.setId(cafePersistence.getId());
        cafeModel.setNome(cafePersistence.getNome());
        cafeModel.setDescricao(cafePersistence.getDescricao());
        cafeModel.setValor(cafePersistence.getValor());
        return cafeModel;
    }
}
