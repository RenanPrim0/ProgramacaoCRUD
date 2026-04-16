package br.com.nilpel.ProjetoCrud.Service;

import br.com.nilpel.ProjetoCrud.Model.Moto;
import br.com.nilpel.ProjetoCrud.Repository.MotoRepository;
import br.com.nilpel.ProjetoCrud.dto.Moto.MotoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;


    public Moto salvar(MotoRequest request) {

        Moto moto = new Moto();
        moto.setMarca(request.marca());
        moto.setModelo(request.modelo());
        moto.setAno(request.ano());
        moto.setCor(request.cor());
        moto.setPlaca(request.placa());
        return motoRepository.save(moto);
    }

    public List<Moto> listarTodos() {
        return motoRepository.findAll();
    }

    public Optional<Moto> buscarPorId(Long id) {
        return motoRepository.findById(id);
    }


    public Moto atualizar(Long id, MotoRequest request) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada com id: " + id));

        moto.setMarca(request.marca());
        moto.setModelo(request.modelo());
        moto.setAno(request.ano());
        moto.setCor(request.cor());
        moto.setPlaca(request.placa());

        return motoRepository.save(moto);
    }

    public void deletar(Long id) {
        if (!motoRepository.existsById(id)) {
            throw new RuntimeException("Moto não encontrada com id: " + id);
        }
        motoRepository.deleteById(id);
    }
}