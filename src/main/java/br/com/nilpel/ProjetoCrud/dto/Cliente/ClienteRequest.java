package br.com.nilpel.ProjetoCrud.dto.Cliente;

public record ClienteRequest(
    String nome,
    String email,
    String telefone,
    String endereco,
    String cpf
) {}
