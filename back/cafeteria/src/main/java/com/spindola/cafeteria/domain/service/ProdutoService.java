package com.spindola.cafeteria.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cafeteria.application.mapper.AdicionalMapper;
import com.spindola.cafeteria.application.mapper.CafeMapper;
import com.spindola.cafeteria.domain.model.AdicionalModel;
import com.spindola.cafeteria.domain.model.CafeModel;
import com.spindola.cafeteria.infrastructure.persistence.entity.AdicionalPersistence;
import com.spindola.cafeteria.infrastructure.persistence.entity.CafePersistence;
import com.spindola.cafeteria.infrastructure.persistence.repository.CafeRepository;
import com.spindola.cafeteria.infrastructure.persistence.repository.ItemAdicionalRepository;
import com.spindola.cafeteria.presentation.dto.AdicionalRequestDTO;
import com.spindola.cafeteria.presentation.dto.AdicionalResponseDTO;
import com.spindola.cafeteria.presentation.dto.CafeRequestDTO;
import com.spindola.cafeteria.presentation.dto.CafeResponseDTO;

@Service
public class ProdutoService {    
    @Autowired
    private CafeRepository cafeRepository;

    @Autowired
    private ItemAdicionalRepository adicionalRepository;

    @Autowired
    private CafeMapper cafeMapper;

    @Autowired
    private AdicionalMapper adicionalMapper;

    public List<CafeResponseDTO> buscarTodosCafes(){
        List<CafePersistence> listaCafe = cafeRepository.findAll();
        List<CafeResponseDTO> listaCafeResponseDTO = new ArrayList<>();
        for(CafePersistence cafe : listaCafe){
            listaCafeResponseDTO.add(cafeMapper.toResponseDTO(cafe));
        }
        return listaCafeResponseDTO;
    }

    public List<AdicionalResponseDTO> buscarTodosAdicional(){
        List<AdicionalPersistence> listaAdicional = adicionalRepository.findAll();
        List<AdicionalResponseDTO> listaAdicionalResponseDTO = new ArrayList<>();
        for(AdicionalPersistence item : listaAdicional){
            listaAdicionalResponseDTO.add(adicionalMapper.toResponseDTO(item));
        } 
        return listaAdicionalResponseDTO;
    }

    public CafeResponseDTO registrarCafe(CafeRequestDTO dto){
        CafeModel novoCafe = cafeMapper.toModel(dto);
        // Validações aqui
        cafeRepository.save(cafeMapper.toEntity(novoCafe));
        CafeResponseDTO cafeResponseDTO = cafeMapper.toResponseDTO(novoCafe);
        return cafeResponseDTO;
    }

    public AdicionalResponseDTO registrarAdicional(AdicionalRequestDTO dto){
        AdicionalModel novoAdicional = adicionalMapper.toModel(dto);
        // Validações aqui
        adicionalRepository.save(adicionalMapper.toEntity(novoAdicional));
        AdicionalResponseDTO adicionalResponseDTO = adicionalMapper.toResponseDTO(novoAdicional);
        return adicionalResponseDTO;
    }
}
