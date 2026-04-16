package br.com.nilpel.ProjetoCrud.Controller;

import br.com.nilpel.ProjetoCrud.Model.Cliente;
import br.com.nilpel.ProjetoCrud.Service.ClienteService;
import br.com.nilpel.ProjetoCrud.dto.Cliente.ClienteRequest;
import br.com.nilpel.ProjetoCrud.dto.Cliente.ClienteResponse;
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
        Cliente salvo = clienteService.salvar(request);
        return ResponseEntity.ok(toResponse(salvo));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteResponse>> listarTodos() {
        List<ClienteResponse> clientes = clienteService.listarTodos()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(cliente -> ResponseEntity.ok(toResponse(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable Long id, @RequestBody ClienteRequest request) {
        Cliente salvo = clienteService.atualizar(id, request);
        return ResponseEntity.ok(toResponse(salvo));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                cliente.getCpf()
        );
    }
}