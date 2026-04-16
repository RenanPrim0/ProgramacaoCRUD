package br.com.nilpel.ProjetoCrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.nilpel.ProjetoCrud.Model.Mecanico;
import br.com.nilpel.ProjetoCrud.Service.MecanicoService;
import br.com.nilpel.ProjetoCrud.dto.Mecanico.MecanicoResponse;
import br.com.nilpel.ProjetoCrud.dto.Mecanico.MecanicoResquest;

import java.util.List;

@RestController
@RequestMapping("/mecanicos")
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    @PostMapping
    public ResponseEntity<MecanicoResponse> criar(@RequestBody MecanicoResquest request) {
        Mecanico salvo = mecanicoService.salvar(request);
        return ResponseEntity.ok(toResponse(salvo));
    }

    @GetMapping
    public ResponseEntity<List<MecanicoResponse>> listarTodos() {
        List<MecanicoResponse> mecanicos = mecanicoService.listarTodos()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(mecanicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MecanicoResponse> buscarPorId(@PathVariable Long id) {
        return mecanicoService.buscarPorId(id)
                .map(mecanico -> ResponseEntity.ok(toResponse(mecanico)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MecanicoResponse> atualizar(@PathVariable Long id, @RequestBody MecanicoResquest request) {
        Mecanico salvo = mecanicoService.atualizar(id, request);
        return ResponseEntity.ok(toResponse(salvo));
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