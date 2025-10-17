package com.spindola.cafeteria.domain.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cafeteria.application.mapper.CafeMapper;
import com.spindola.cafeteria.domain.exceptions.CampoObrigatorioNuloException;
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
        if(dto.nome().trim().isEmpty()) throw new CampoObrigatorioNuloException("nome");
        if(dto.descrica().trim().isEmpty()) throw new CampoObrigatorioNuloException("descricao");
        if(dto.valor().compareTo(BigDecimal.ZERO) < 0) throw new CampoObrigatorioNuloException("valor");

        CafeModel novoCafe = cafeMapper.toModel(dto);

        return cafeMapper.toResponseDTO(cafeRepository.save(cafeMapper.toEntity(novoCafe)));
    }

}
