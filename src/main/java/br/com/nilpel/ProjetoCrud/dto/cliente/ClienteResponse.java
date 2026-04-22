package br.com.nilpel.ProjetoCrud.dto.cliente;

public record ClienteResponse(
    Long id,
    String nome,
    String email,
    String telefone,
    String endereco,
    String cpf
) {

}
