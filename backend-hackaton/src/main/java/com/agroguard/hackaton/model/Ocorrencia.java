package com.agroguard.hackaton.model;

import com.agroguard.hackaton.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ocorencia")
public class Ocorrencia {

    @Id
    @GeneratedValue(generator = "UUIDGenerator")
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @Column(name = "ocorrencia_id", updatable = false, nullable = false)
    private UUID id;

    private Integer hectares;

    private Integer hectaresAfetados;

    private String cultura;

    private String variedade;

    private Float latitude;

    private Float longitude;

    private byte[] fotoOcorrencia;

    @ElementCollection
    @CollectionTable(name = "dados_meteorologicos", joinColumns = @JoinColumn(name = "ocorrencia_id"))
    @Column(name = "dado")
    private List<String> dadosMetereologicos;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @Enumerated(EnumType.STRING)
    private Status status;

}
