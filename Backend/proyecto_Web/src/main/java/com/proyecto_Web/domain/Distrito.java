package com.proyecto_Web.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity @Table(name = "distrito") @Data
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distrito_id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Relación opcional para navegar desde distrito a vínculos con normativas
    @JsonIgnore
    @OneToMany(mappedBy = "distrito", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NormativaDistrito> normativasVinculos;
}
