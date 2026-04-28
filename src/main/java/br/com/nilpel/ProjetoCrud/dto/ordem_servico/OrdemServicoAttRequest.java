package br.com.nilpel.ProjetoCrud.dto.ordem_servico;

import java.util.List;

import br.com.nilpel.ProjetoCrud.enums.StatusOS;

public record OrdemServicoAttRequest(   

    Long id,
    StatusOS status,
    String descricao,
    Long motoId,
    Long clienteId,
    List<Long> mecanicosId
    
) {
    
}
