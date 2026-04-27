package br.com.nilpel.ProjetoCrud.dto.ordem_servico;

import br.com.nilpel.ProjetoCrud.enums.StatusOS;

import java.util.List;

public record OrdemServicoRequest (
    Long clienteId,
    Long motoId,
    List<Long> mecanicosId,
    String descricao,
    Double valor,
    StatusOS status
) {
}
