package com.spindola.cafeteria.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.cafeteria.domain.service.ProdutoService;
import com.spindola.cafeteria.presentation.dto.AdicionalRequestDTO;
import com.spindola.cafeteria.presentation.dto.AdicionalResponseDTO;
import com.spindola.cafeteria.presentation.dto.CafeRequestDTO;
import com.spindola.cafeteria.presentation.dto.CafeResponseDTO;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/cafe")
    public List<CafeResponseDTO> buscarTodosCafes(){
        return this.service.buscarTodosCafes();
    }

    @GetMapping(value = "/adicionais")
    public List<AdicionalResponseDTO> buscarTodosAdicional(){
        return this.service.buscarTodosAdicional();
    }

    @PostMapping(value = "/cafe/cadastro")
    public CafeResponseDTO adicionarCafe(@RequestBody CafeRequestDTO cafeDTO){
        return this.service.registrarCafe(cafeDTO);
    }

    @PostMapping(value = "/adicionais/cadastro")
    public AdicionalResponseDTO adicionarAdicional(@RequestBody AdicionalRequestDTO adicionalDTO){
        return this.service.registrarAdicional(adicionalDTO);
    }
    
    /*
    
    @PostMapping(value = "/entrada")
    public Veiculo salvaEntrada(@RequestBody Veiculo veiculo){
        return this.service.registrarEntrada(veiculo);
    }

    @GetMapping
    public List<Veiculo> buscarTodos(){
        return this.service.buscarTodos();
    }

    @GetMapping(value = "/ativos")
    public List<Veiculo> buscarAtivos(){
        return this.service.listarEstacionados();
    } 
    */
}
