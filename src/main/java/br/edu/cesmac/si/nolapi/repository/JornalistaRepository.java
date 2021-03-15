package br.edu.cesmac.si.nolapi.repository;

import br.edu.cesmac.si.nolapi.domain.Jornalista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornalistaRepository extends JpaRepository <Jornalista, Long>{

}
