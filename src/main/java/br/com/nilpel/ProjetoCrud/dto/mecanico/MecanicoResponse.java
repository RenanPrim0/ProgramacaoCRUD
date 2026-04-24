package br.com.nilpel.ProjetoCrud.dto.mecanico;

import br.com.nilpel.ProjetoCrud.model.Mecanico;

public record MecanicoResponse(
    Long id,
    String nome,
    String telefone,
    String cpf
) {
    public MecanicoResponse(Mecanico mecanico){
        this(mecanico.getId(), mecanico.getNome(), mecanico.getTelefone(), mecanico.getCpf());
    }
}
