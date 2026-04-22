package br.com.nilpel.ProjetoCrud.dto.cliente;

public record ClienteRequest(
    String nome,
    String email,
    String telefone,
    String endereco,
    String cpf
) {}
