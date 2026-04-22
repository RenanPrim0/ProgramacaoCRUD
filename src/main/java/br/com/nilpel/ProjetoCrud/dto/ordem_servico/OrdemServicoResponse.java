package br.com.nilpel.ProjetoCrud.dto.ordem_servico;

import br.com.nilpel.ProjetoCrud.model.Cliente;
import br.com.nilpel.ProjetoCrud.model.Mecanico;
import br.com.nilpel.ProjetoCrud.model.Moto;

import java.time.LocalDateTime;
import java.util.List;

public record OrdemServicoResponse (

        Long id,
        Cliente cliente,
        Moto moto,
        List<Mecanico> mecanicos,
        LocalDateTime dataAbertura,
        LocalDateTime dataFechamento,
        String descricao,
        Double valor,
        String status


        ) {
}
