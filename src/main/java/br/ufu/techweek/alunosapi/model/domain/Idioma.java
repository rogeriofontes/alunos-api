package br.ufu.techweek.alunosapi.model.domain;

import lombok.*;

import javax.persistence.Entity;

@Entity(name = "tb_idoma")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true, of = {"description"})
@Builder
@Data
public class Idioma extends EntityId {

    private String nome;

}
