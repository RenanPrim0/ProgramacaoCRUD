package br.com.nilpel.ProjetoCrud.dto.Moto;

public record MotoRequest(
        String marca,
        String modelo,
        int ano,
        String cor,
        String placa
) {

}
