package br.com.nilpel.ProjetoCrud.dto.ordem_servico;

import br.com.nilpel.ProjetoCrud.dto.cliente.ClienteResponse;
import br.com.nilpel.ProjetoCrud.dto.mecanico.MecanicoResponse;
import br.com.nilpel.ProjetoCrud.dto.moto.MotoResponse;
import br.com.nilpel.ProjetoCrud.model.Cliente;
import br.com.nilpel.ProjetoCrud.model.Mecanico;
import br.com.nilpel.ProjetoCrud.model.Moto;
import br.com.nilpel.ProjetoCrud.model.OrdemServico;

import java.time.LocalDateTime;
import java.util.List;

public record OrdemServicoResponse (

        Long id,
        ClienteResponse cliente,
        MotoResponse moto,
        List<MecanicoResponse> mecanicos,
        LocalDateTime dataAbertura,
        LocalDateTime dataFechamento,
        String descricao,
        Double valor,
        String status

        ) {
        public OrdemServicoResponse(OrdemServico os) {
                this(
                        os.getId(),
                        new ClienteResponse(os.getCliente()),
                        new MotoResponse(os.getMoto()),
                        os.getMecanicos().stream().map(MecanicoResponse::new).toList(),
                        os.getDataAbertura(),
                        os.getDataFechamento(),
                        os.getDescricao(),
                        os.getValor(),
                        os.getStatus().name()
                );
        }

}