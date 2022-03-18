package br.ufu.techweek.alunosapi.model.repository;

import br.ufu.techweek.alunosapi.model.domain.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long> {

}
