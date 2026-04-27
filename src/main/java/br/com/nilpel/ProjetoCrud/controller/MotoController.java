package br.com.nilpel.ProjetoCrud.controller;


import br.com.nilpel.ProjetoCrud.service.MotoService;
import br.com.nilpel.ProjetoCrud.dto.moto.MotoAltRequest;
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

    @PostMapping("/criar")
    public ResponseEntity<MotoResponse> criar(@RequestBody MotoRequest request) {
        return ResponseEntity.ok(motoService.salvar(request));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MotoResponse>> listarTodos() {
        return ResponseEntity.ok(motoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(motoService.buscarPorId(id));
    }

    @PutMapping("/alterar")
    public ResponseEntity<MotoResponse> atualizar(@RequestBody MotoAltRequest request) {
        return ResponseEntity.ok(motoService.atualizar(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        motoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}