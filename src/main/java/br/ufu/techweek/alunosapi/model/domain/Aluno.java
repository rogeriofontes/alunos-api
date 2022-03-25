package br.ufu.techweek.alunosapi.model.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "tb_aluno")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true, of = { "description" })
@Builder
@Data
public class Aluno extends EntityId {

    @Column(nullable = false)
    private String nome;

    @Column(name = "curriculo_de_aluno", nullable = true)
    private String curriculo;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToMany
    @JoinTable(name = "aluno_idioma", joinColumns = {
            @JoinColumn(name = "aluno_id") }, inverseJoinColumns = {
            @JoinColumn(name = "idioma_id") })
    private List<Idioma> idiomas;

}
