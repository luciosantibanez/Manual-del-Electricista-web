package com.proyecto_Web.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "normativa_distrito")
public class NormativaDistrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "distrito_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_nd_distrito"))
    private Distrito distrito;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "normativa_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_nd_normativa"))
    private Normativa normativa;
}
