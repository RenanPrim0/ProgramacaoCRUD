package br.com.nilpel.ProjetoCrud.dto.moto;

public record MotoResponse(
    Long id,
    String marca,
    String modelo,
    int ano,
    String cor,
    String placa
) {
    
}
