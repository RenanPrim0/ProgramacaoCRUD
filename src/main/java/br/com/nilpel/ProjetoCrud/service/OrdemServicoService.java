package br.com.nilpel.ProjetoCrud.service;

import br.com.nilpel.ProjetoCrud.repository.ClienteRepository;
import br.com.nilpel.ProjetoCrud.repository.MecanicoRepository;
import br.com.nilpel.ProjetoCrud.repository.MotoRepository;
import br.com.nilpel.ProjetoCrud.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoService {
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private MecanicoRepository mecanicoRepository;
}
