package br.ufu.techweek.alunosapi.model.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_aluno")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true, of = { "description" })
@Builder
@Data
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "curriculo_de_aluno", nullable = true)
    private String curriculo;
}
