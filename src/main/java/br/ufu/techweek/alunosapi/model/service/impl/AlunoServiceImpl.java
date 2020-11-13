package br.ufu.techweek.alunosapi.model.service.impl;

import br.ufu.techweek.alunosapi.model.domain.Aluno;
import br.ufu.techweek.alunosapi.model.repository.AlunoRepository;
import br.ufu.techweek.alunosapi.model.service.AlunoService;
import br.ufu.techweek.alunosapi.model.service.Desconto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno salvar(Aluno aluno) {
        BigDecimal comissao = calculaComissao(new BigDecimal(100));
        log.info("Comissao calculada: " + comissao );
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno editar(Long id, Aluno aluno) {
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> list() {
        return alunoRepository.findAll();
    }

    @Override
    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }

    public BigDecimal calculaComissao(BigDecimal valor) {
       return Desconto.getType(Desconto.FIES.name()).calculaDesconto(valor);
    }
}
