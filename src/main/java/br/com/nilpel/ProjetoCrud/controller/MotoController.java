package br.com.nilpel.ProjetoCrud.controller;

import br.com.nilpel.ProjetoCrud.model.Moto;
import br.com.nilpel.ProjetoCrud.service.MotoService;
import br.com.nilpel.ProjetoCrud.dto.moto.MotoRequest;
import br.com.nilpel.ProjetoCrud.dto.moto.MotoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @PostMapping
    public ResponseEntity<MotoResponse> criar(@RequestBody MotoRequest request) {
        return ResponseEntity.ok(motoService.salvar(request));
    }

    @GetMapping
    public ResponseEntity<List<MotoResponse>> listarTodos() {
        return ResponseEntity.ok(motoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(motoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoResponse> atualizar(@PathVariable Long id, @RequestBody MotoRequest request) {
        return ResponseEntity.ok(motoService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        motoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private MotoResponse toResponse(Moto moto) {
        return new MotoResponse(
                moto.getId(),
                moto.getMarca(),
                moto.getModelo(),
                moto.getAno(),
                moto.getCor(),
                moto.getPlaca()
        );
    }
}