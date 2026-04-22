package br.com.nilpel.ProjetoCrud.dto.cliente;

public record ClienteAltRequest(
    String nome,
    String email,
    String telefone,
    String endereco,
    String cpf
) {

}
