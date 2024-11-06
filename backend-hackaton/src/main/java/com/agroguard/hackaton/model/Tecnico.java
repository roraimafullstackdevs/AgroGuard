package com.agroguard.hackaton.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(generator = "UUIDGenerator")
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @Column(name = "tecnico_id", updatable = false, nullable = false)
    private UUID id;
    private String nome;
    private String CREA;
    private String cpf;
    private String email;
    private String senha;
    private String instituicao;

}
