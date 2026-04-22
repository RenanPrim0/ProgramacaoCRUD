package br.com.nilpel.ProjetoCrud.repository;


import br.com.nilpel.ProjetoCrud.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}
