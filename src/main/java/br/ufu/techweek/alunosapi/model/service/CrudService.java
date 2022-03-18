package br.ufu.techweek.alunosapi.model.service;

import br.ufu.techweek.alunosapi.model.domain.Aluno;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID extends Serializable> {
    T salvar(T t);
    T editar(ID id, T t);
    List<T> list();
    Optional<T> findById(ID id);
    void delete(Long id);
}
