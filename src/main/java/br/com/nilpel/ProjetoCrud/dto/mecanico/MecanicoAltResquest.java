package br.com.nilpel.ProjetoCrud.dto.mecanico;

public record MecanicoAltResquest (
    Long id,
    String nome,
    String telefone,
    String cpf
) {
    
}
