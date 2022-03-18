package br.ufu.techweek.alunosapi.model.repository;

import br.ufu.techweek.alunosapi.model.domain.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
