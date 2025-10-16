package com.spindola.cafeteria.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cafeteria.application.mapper.CafeMapper;
import com.spindola.cafeteria.domain.model.CafeModel;
import com.spindola.cafeteria.infrastructure.persistence.entity.CafePersistence;
import com.spindola.cafeteria.infrastructure.persistence.repository.CafeRepository;
import com.spindola.cafeteria.presentation.dto.CafeRequestDTO;
import com.spindola.cafeteria.presentation.dto.CafeResponseDTO;

@Service
public class ProdutoService {
    @Autowired
    private CafeRepository cafeRepository;
    
    @Autowired
    private CafeMapper cafeMapper;

    public List<CafeResponseDTO> buscarTodosCafes(){
        List<CafePersistence> listaCafe = cafeRepository.findAll();
        List<CafeResponseDTO> listaCafeResponseDTO = new ArrayList<>();
        for(CafePersistence cafe : listaCafe){
            listaCafeResponseDTO.add(cafeMapper.toResponseDTO(cafe));
        }
        return listaCafeResponseDTO;
    }

    public CafeResponseDTO registrarCafe(CafeRequestDTO dto){
        CafeModel novoCafe = cafeMapper.toModel(dto);
        CafeResponseDTO cafeResponseDTO = cafeMapper.toResponseDTO(cafeRepository.save(cafeMapper.toEntity(novoCafe)));
        return cafeResponseDTO;
    }

}
