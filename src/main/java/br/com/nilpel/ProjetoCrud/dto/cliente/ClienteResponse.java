package br.com.nilpel.ProjetoCrud.dto.cliente;

import br.com.nilpel.ProjetoCrud.model.Cliente;

public record ClienteResponse(
    Long id,
    String nome,
    String email,
    String telefone,
    String endereco,
    String cpf
) {
    public ClienteResponse(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco(), cliente.getCpf());
    }
}
