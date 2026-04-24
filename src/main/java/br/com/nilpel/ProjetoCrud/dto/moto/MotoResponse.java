package br.com.nilpel.ProjetoCrud.dto.moto;

import br.com.nilpel.ProjetoCrud.model.Moto;

public record MotoResponse(
    Long id,
    String marca,
    String modelo,
    int ano,
    String cor,
    String placa
) {
    public MotoResponse(Moto moto){
        this(moto.getId(), moto.getMarca(), moto.getModelo(), moto.getAno(), moto.getCor(), moto.getPlaca());
    }
}
