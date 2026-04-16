package br.com.nilpel.ProjetoCrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nilpel.ProjetoCrud.Model.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {

}
