package br.com.nilpel.ProjetoCrud.dto.Mecanico;

public record MecanicoResponse(
    Long id,
    String nome,
    String telefone,
    String cpf
) {

}
