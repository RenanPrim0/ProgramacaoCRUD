package br.com.nilpel.ProjetoCrud.dto.mecanico;

public record MecanicoResponse(
    Long id,
    String nome,
    String telefone,
    String cpf
) {

}
