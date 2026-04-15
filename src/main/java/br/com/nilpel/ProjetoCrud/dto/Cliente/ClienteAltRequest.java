package br.com.nilpel.ProjetoCrud.dto.Cliente;

public record ClienteAltRequest(
    String nome,
    String email,
    String telefone,
    String endereco,
    String cpf
) {

}
