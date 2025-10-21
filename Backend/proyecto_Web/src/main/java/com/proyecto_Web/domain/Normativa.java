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
@Entity
@Table(name = "normativa")
public class Normativa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "normativa_id")
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Lob
    @Column(name = "descripcion_corta", columnDefinition = "TEXT")
    private String descripcionCorta;

    @Column(name = "url_documento", nullable = false, length = 255)
    private String urlDocumento;

    // Relación opcional para navegar desde normativa a vínculos con distritos
    @JsonIgnore
    @OneToMany(mappedBy = "normativa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NormativaDistrito> distritosVinculos;
}
