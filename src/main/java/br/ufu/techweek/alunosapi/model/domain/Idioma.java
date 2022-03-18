package br.ufu.techweek.alunosapi.model.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_idoma")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true, of = { "description" })
@Builder
@Data
public class Idioma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
}
