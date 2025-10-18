package com.spindola.cafeteria.domain.exceptions;

public class CampoObrigatorioNuloException extends RuntimeException {

    public CampoObrigatorioNuloException() {
        super("Um campo obrigatório não foi fornecido.");
    }
    
    public CampoObrigatorioNuloException(String messagem){
        super("O campo obrigatório '" + messagem + "' não pode ser nulo ou vazio.");
    }
}
