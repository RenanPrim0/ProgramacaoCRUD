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
        Moto salvo = motoService.salvar(request);
        return ResponseEntity.ok(toResponse(salvo));
    }

    @GetMapping
    public ResponseEntity<List<MotoResponse>> listarTodos() {
        List<MotoResponse> motos = motoService.listarTodos()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoResponse> buscarPorId(@PathVariable Long id) {
        return motoService.buscarPorId(id)
                .map(moto -> ResponseEntity.ok(toResponse(moto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoResponse> atualizar(@PathVariable Long id, @RequestBody MotoRequest request) {
        Moto salva = motoService.atualizar(id, request);
        return ResponseEntity.ok(toResponse(salva));
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