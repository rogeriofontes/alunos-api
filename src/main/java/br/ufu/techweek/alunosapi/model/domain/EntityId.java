package br.ufu.techweek.alunosapi.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class EntityId implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    @CreatedBy
    private String createBy = "Usuario do Sistema";

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedBy = "Usuario do Sistema";

}
