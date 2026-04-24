package br.com.nilpel.ProjetoCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.nilpel.ProjetoCrud.model.Mecanico;
import br.com.nilpel.ProjetoCrud.service.MecanicoService;
import br.com.nilpel.ProjetoCrud.dto.mecanico.MecanicoResponse;
import br.com.nilpel.ProjetoCrud.dto.mecanico.MecanicoResquest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mecanicos")
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    @PostMapping
    public ResponseEntity<MecanicoResponse> criar(@RequestBody MecanicoResquest request) {
        return ResponseEntity.ok(mecanicoService.salvar(request));
    }

    @GetMapping
    public ResponseEntity<List<MecanicoResponse>> listarTodos() {
        return ResponseEntity.ok(mecanicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MecanicoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mecanicoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MecanicoResponse> atualizar(@PathVariable Long id, @RequestBody MecanicoResquest request) {
        return ResponseEntity.ok(mecanicoService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        mecanicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private MecanicoResponse toResponse(Mecanico mecanico) {
        return new MecanicoResponse(
                mecanico.getId(),
                mecanico.getNome(),
                mecanico.getTelefone(),
                mecanico.getCpf()
        );
    }
}