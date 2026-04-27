package br.com.nilpel.ProjetoCrud.controller;

import br.com.nilpel.ProjetoCrud.dto.ordem_servico.OrdemServicoRequest;
import br.com.nilpel.ProjetoCrud.dto.ordem_servico.OrdemServicoResponse;
import br.com.nilpel.ProjetoCrud.enums.StatusOS;
import br.com.nilpel.ProjetoCrud.service.OrdemServicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/ordem_servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping("/criar")
    public ResponseEntity<OrdemServicoResponse> criar(@RequestBody OrdemServicoRequest request) {
        return ResponseEntity.ok(ordemServicoService.salvar(
                request.clienteId(),
                request.motoId(),
                request.mecanicosId(),
                request.descricao(),
                request.valor()
                )
        );
    }

    @GetMapping("/listar")
    public ResponseEntity<List<OrdemServicoResponse>> listarTodos() {
        return ResponseEntity.ok(ordemServicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServicoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ordemServicoService.buscarPorId(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<OrdemServicoResponse> atualizarStatus(@PathVariable Long id, @RequestParam StatusOS status) {
        return ResponseEntity.ok(ordemServicoService.atualizarStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ordemServicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}