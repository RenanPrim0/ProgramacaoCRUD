package br.com.nilpel.ProjetoCrud.service;

import java.util.List;

import br.com.nilpel.ProjetoCrud.dto.mecanico.MecanicoAltResquest;
import br.com.nilpel.ProjetoCrud.dto.mecanico.MecanicoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.nilpel.ProjetoCrud.model.Mecanico;
import br.com.nilpel.ProjetoCrud.repository.MecanicoRepository;
import br.com.nilpel.ProjetoCrud.dto.mecanico.MecanicoResquest;

@Service
public class MecanicoService {
    @Autowired
    private MecanicoRepository mecanicoRepository;

    public MecanicoResponse salvar(MecanicoResquest request) {
        Mecanico mecanico = new Mecanico();
        mecanico.setNome(request.nome());
        mecanico.setTelefone(request.telefone());
        mecanico.setCpf(request.cpf());
        mecanicoRepository.save(mecanico);
        return new MecanicoResponse(mecanico);
    }

    public List<MecanicoResponse> listarTodos() {
        return mecanicoRepository.findAll().stream().map(MecanicoResponse::new).toList();
    }

    public MecanicoResponse buscarPorId(Long id) {
        Mecanico mecanico = mecanicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Mecânico não encontrado com id: " + id));
        return new MecanicoResponse(mecanico);
    }

    public MecanicoResponse atualizar(MecanicoAltResquest request) {
        Mecanico mecanico = mecanicoRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Mecânico não encontrado com id: " + request.id()));

        mecanico.setNome(request.nome());
        mecanico.setTelefone(request.telefone());
        mecanico.setCpf(request.cpf());

        mecanicoRepository.save(mecanico);
        return new MecanicoResponse(mecanico);
    }

    public void deletar(Long id) {
        if (!mecanicoRepository.existsById(id)) {
            throw new RuntimeException("Mecânico não encontrado com id: " + id);
        }
        mecanicoRepository.deleteById(id);
    }

}
