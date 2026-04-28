package br.com.nilpel.ProjetoCrud.service;

import java.util.List;

import br.com.nilpel.ProjetoCrud.dto.cliente.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.nilpel.ProjetoCrud.model.Cliente;
import br.com.nilpel.ProjetoCrud.repository.ClienteRepository;
import br.com.nilpel.ProjetoCrud.dto.cliente.ClienteAltRequest;
import br.com.nilpel.ProjetoCrud.dto.cliente.ClienteRequest;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponse salvar(ClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setNome(request.nome());
        cliente.setEmail(request.email());
        cliente.setTelefone(request.telefone());
        cliente.setEndereco(request.endereco());
        cliente.setCpf(request.cpf());
        clienteRepository.save(cliente);
        return new ClienteResponse(cliente);
    }

    public List<ClienteResponse> listarTodos() {
        return clienteRepository.findAll().stream().map(ClienteResponse::new).toList();
    }

    public ClienteResponse buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
        return new ClienteResponse(cliente);
    }

    public ClienteResponse atualizar(ClienteAltRequest request) {
        Cliente cliente = clienteRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + request.id()));

        cliente.setNome(request.nome());
        cliente.setEmail(request.email());
        cliente.setTelefone(request.telefone());
        cliente.setEndereco(request.endereco());
        cliente.setCpf(request.cpf());

        clienteRepository.save(cliente);
        return new ClienteResponse(cliente);
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com id: " + id);
        }
        clienteRepository.deleteById(id);
    }
}