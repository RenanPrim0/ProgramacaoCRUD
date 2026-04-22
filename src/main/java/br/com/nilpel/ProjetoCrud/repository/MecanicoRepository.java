package br.com.nilpel.ProjetoCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nilpel.ProjetoCrud.model.Mecanico;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

}
