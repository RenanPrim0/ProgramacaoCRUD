package br.com.nilpel.ProjetoCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.nilpel.ProjetoCrud.service.MecanicoService;
import br.com.nilpel.ProjetoCrud.dto.mecanico.MecanicoAltResquest;
import br.com.nilpel.ProjetoCrud.dto.mecanico.MecanicoResponse;
import br.com.nilpel.ProjetoCrud.dto.mecanico.MecanicoResquest;
import java.util.List;

@RestController
@RequestMapping("/mecanico")
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<MecanicoResponse> criar(@RequestBody MecanicoResquest request) {
        return ResponseEntity.ok(mecanicoService.salvar(request));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MecanicoResponse>> listarTodos() {
        return ResponseEntity.ok(mecanicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MecanicoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mecanicoService.buscarPorId(id));
    }

    @PutMapping("/alterar")
    public ResponseEntity<MecanicoResponse> atualizar(@RequestBody MecanicoAltResquest request) {
        return ResponseEntity.ok(mecanicoService.atualizar(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        mecanicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}