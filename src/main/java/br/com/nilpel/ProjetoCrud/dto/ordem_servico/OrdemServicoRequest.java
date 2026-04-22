package br.com.nilpel.ProjetoCrud.dto.ordem_servico;

import java.time.LocalDateTime;
import java.util.List;

public record OrdemServicoRequest (
    Long clienteId,
    Long motoId,
    List<Long> mecanicosId,
    LocalDateTime dataAbertura,
    LocalDateTime dataFechamento,
    String descricao,
    Double valor,
    String status
) {
}
