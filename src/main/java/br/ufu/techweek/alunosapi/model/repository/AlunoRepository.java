package br.ufu.techweek.alunosapi.model.repository;

import br.ufu.techweek.alunosapi.model.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
