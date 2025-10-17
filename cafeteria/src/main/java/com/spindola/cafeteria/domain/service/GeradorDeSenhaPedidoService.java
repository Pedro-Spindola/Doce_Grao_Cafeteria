package com.spindola.cafeteria.domain.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class GeradorDeSenhaPedidoService {

    Integer senhaAtual = 0;
    LocalDate dataLocal;

    public String gerarNovaSenha() {
        LocalDate hoje = LocalDate.now();

        if (dataLocal.isBefore(hoje)) senhaAtual = 1;
        senhaAtual++;
        String numeroFormatado = String.format("%04d", senhaAtual); 
        return numeroFormatado;
    }
}
