package br.com.nilpel.ProjetoCrud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nilpel.ProjetoCrud.Model.Mecanico;
import br.com.nilpel.ProjetoCrud.Repository.MecanicoRepository;
import br.com.nilpel.ProjetoCrud.dto.Mecanico.MecanicoResquest;

@Service
public class MecanicoService {
    @Autowired
    private MecanicoRepository mecanicoRepository;

    public Mecanico salvar(MecanicoResquest request) {
        Mecanico mecanico = new Mecanico();
        mecanico.setNome(request.nome());
        mecanico.setTelefone(request.telefone());
        mecanico.setCpf(request.cpf());
        return mecanicoRepository.save(mecanico);
    }

    public List<Mecanico> listarTodos() {
        return mecanicoRepository.findAll();
    }

    public Optional<Mecanico> buscarPorId(Long id) {
        return mecanicoRepository.findById(id);
    }

    public Mecanico atualizar(Long id, MecanicoResquest request) {
        Mecanico mecanico = mecanicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mecânico não encontrado com id: " + id));

        mecanico.setNome(request.nome());
        mecanico.setTelefone(request.telefone());
        mecanico.setCpf(request.cpf());

        return mecanicoRepository.save(mecanico);
    }

    public void deletar(Long id) {
        if (!mecanicoRepository.existsById(id)) {
            throw new RuntimeException("Mecânico não encontrado com id: " + id);
        }
        mecanicoRepository.deleteById(id);
    }

}
