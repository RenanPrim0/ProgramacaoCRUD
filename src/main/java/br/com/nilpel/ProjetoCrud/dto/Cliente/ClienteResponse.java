package br.com.nilpel.ProjetoCrud.dto.Cliente;

public record ClienteResponse(
    Long id,
    String nome,
    String email,
    String telefone,
    String endereco,
    String cpf
) {

}
