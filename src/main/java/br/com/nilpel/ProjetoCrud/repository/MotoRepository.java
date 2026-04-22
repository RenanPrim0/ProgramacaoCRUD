package br.com.nilpel.ProjetoCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nilpel.ProjetoCrud.model.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {

}
