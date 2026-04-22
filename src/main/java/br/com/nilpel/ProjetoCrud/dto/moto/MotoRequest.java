package br.com.nilpel.ProjetoCrud.dto.moto;

public record MotoRequest(
        String marca,
        String modelo,
        int ano,
        String cor,
        String placa
) {

}
