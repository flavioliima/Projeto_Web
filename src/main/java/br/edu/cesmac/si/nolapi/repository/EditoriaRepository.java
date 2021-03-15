package br.edu.cesmac.si.nolapi.repository;

import br.edu.cesmac.si.nolapi.domain.Editoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoriaRepository extends JpaRepository<Editoria, Long> {

}
