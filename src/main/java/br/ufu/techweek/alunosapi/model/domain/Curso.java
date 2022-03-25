package br.ufu.techweek.alunosapi.model.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_vaga")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true, of = { "description" })
@Builder
@Data
public class Curso extends EntityId {

    @Column(nullable = false)
    private String nome;

}
