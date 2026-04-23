package br.com.nilpel.ProjetoCrud.service;

import br.com.nilpel.ProjetoCrud.enums.StatusOS;
import br.com.nilpel.ProjetoCrud.model.Cliente;
import br.com.nilpel.ProjetoCrud.model.Mecanico;
import br.com.nilpel.ProjetoCrud.model.Moto;
import br.com.nilpel.ProjetoCrud.model.OrdemServico;
import br.com.nilpel.ProjetoCrud.repository.ClienteRepository;
import br.com.nilpel.ProjetoCrud.repository.MecanicoRepository;
import br.com.nilpel.ProjetoCrud.repository.MotoRepository;
import br.com.nilpel.ProjetoCrud.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private MecanicoRepository mecanicoRepository;

    public OrdemServico salvar(Long clienteId, Long motoId, List<Long> mecanicosIds, String descricao, Double valor) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Moto moto = motoRepository.findById(motoId).orElseThrow(() -> new RuntimeException("Moto não encontrada"));

        List<Mecanico> mecanicos = mecanicoRepository.findAllById(mecanicosIds);
        if (mecanicos.isEmpty()){
            throw new RuntimeException("Nenhum mecânico encontrado");
        }

        OrdemServico os = new OrdemServico();
        os.setCliente(cliente);
        os.setMoto(moto);
        os.setMecanicos(mecanicos);
        os.setDescricao(descricao);
        os.setValor(valor);
        os.setDataAbertura(LocalDateTime.now());
        os.setDataFechamento(LocalDateTime.now());
        os.setStatus(StatusOS.ABERTA);

        return ordemServicoRepository.save(os);
    }
    public List<OrdemServico> listarTodos() {
        return ordemServicoRepository.findAll();
    }

    public Optional<OrdemServico> buscarPorId(Long id) {
        return ordemServicoRepository.findById(id);
    }

    public OrdemServico atualizarStatus(Long id, StatusOS status) {
        OrdemServico os = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OS não encontrada com id: " + id));

        os.setStatus(status);

        if (status == StatusOS.CONCLUIDA || status == StatusOS.CANCELADA) {
            os.setDataFechamento(LocalDateTime.now());
        }

        return ordemServicoRepository.save(os);
    }
    public void deletar(Long id) {
        if (!ordemServicoRepository.existsById(id)) {
            throw new RuntimeException("OS não encontrada com id: " + id);
        }
        ordemServicoRepository.deleteById(id);
    }
}
