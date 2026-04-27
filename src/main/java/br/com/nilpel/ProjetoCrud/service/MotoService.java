package br.com.nilpel.ProjetoCrud.service;

import br.com.nilpel.ProjetoCrud.dto.moto.MotoResponse;
import br.com.nilpel.ProjetoCrud.model.Moto;
import br.com.nilpel.ProjetoCrud.repository.MotoRepository;
import br.com.nilpel.ProjetoCrud.dto.moto.MotoAltRequest;
import br.com.nilpel.ProjetoCrud.dto.moto.MotoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;


    public MotoResponse salvar(MotoRequest request) {

        Moto moto = new Moto();
        moto.setMarca(request.marca());
        moto.setModelo(request.modelo());
        moto.setAno(request.ano());
        moto.setCor(request.cor());
        moto.setPlaca(request.placa());
        motoRepository.save(moto);
        return new MotoResponse(moto);
    }

    public List<MotoResponse> listarTodos() {
        return motoRepository.findAll().stream().map(MotoResponse::new).toList();
    }

    public MotoResponse buscarPorId(Long id) {
        Moto moto = motoRepository.findById(id).orElseThrow(() -> new RuntimeException("Moto não encontrada com id: " + id));
        return new MotoResponse(moto);
    }


    public MotoResponse atualizar(MotoAltRequest request) {
        Moto moto = motoRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Moto não encontrada com id: " + request.id()));

        moto.setMarca(request.marca());
        moto.setModelo(request.modelo());
        moto.setAno(request.ano());
        moto.setCor(request.cor());
        moto.setPlaca(request.placa());

        motoRepository.save(moto);
        return new MotoResponse(moto);
    }

    public void deletar(Long id) {
        if (!motoRepository.existsById(id)) {
            throw new RuntimeException("Moto não encontrada com id: " + id);
        }
        motoRepository.deleteById(id);
    }
}