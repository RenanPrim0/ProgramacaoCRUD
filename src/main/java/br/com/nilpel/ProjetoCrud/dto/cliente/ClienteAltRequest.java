package br.com.nilpel.ProjetoCrud.dto.cliente;

public record ClienteAltRequest(
    Long id,
    String nome,
    String email,
    String telefone,
    String endereco,
    String cpf
) {

}
