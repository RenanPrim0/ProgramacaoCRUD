package br.com.nilpel.ProjetoCrud.controller;

import br.com.nilpel.ProjetoCrud.service.ClienteService;
import br.com.nilpel.ProjetoCrud.dto.cliente.ClienteAltRequest;
import br.com.nilpel.ProjetoCrud.dto.cliente.ClienteRequest;
import br.com.nilpel.ProjetoCrud.dto.cliente.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteResponse> criar(@RequestBody ClienteRequest request) {
        return ResponseEntity.ok(clienteService.salvar(request));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteResponse>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PutMapping("/alterar")
    public ResponseEntity<ClienteResponse> atualizar(@RequestBody ClienteAltRequest request) {
        return ResponseEntity.ok(clienteService.atualizar(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}