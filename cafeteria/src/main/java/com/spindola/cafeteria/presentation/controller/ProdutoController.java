package com.spindola.cafeteria.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.cafeteria.domain.service.ProdutoService;
import com.spindola.cafeteria.presentation.dto.CafeRequestDTO;
import com.spindola.cafeteria.presentation.dto.CafeResponseDTO;

@RestController
@RequestMapping("api/v1/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/cafe")
    public List<CafeResponseDTO> buscarTodosCafes(){
        return this.service.buscarTodosCafes();
    }

    @PostMapping(value = "/cafe/cadastro")
    public CafeResponseDTO adicionarCafe(@RequestBody CafeRequestDTO cafeDTO){
        return this.service.registrarCafe(cafeDTO);
    }

}
