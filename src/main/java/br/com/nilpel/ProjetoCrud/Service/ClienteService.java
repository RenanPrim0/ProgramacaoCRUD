package br.com.nilpel.ProjetoCrud.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.nilpel.ProjetoCrud.dto.Cliente.ClienteAltRequest;

@Service
public class ClienteService {

    @PostMapping("/clientes") 
    public void salvarCliente(ClienteAltRequest clienteAltRequest)
    {
        
    }
}
