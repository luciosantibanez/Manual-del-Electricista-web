package com.proyecto_Web.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity @Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "marca", length = 255)
    private String marca;

    @Column(name = "modelo", length = 255)
    private String modelo;

    @Column(name = "tipo_material", nullable = false, length = 50)
    private String tipoMaterial;

    @Column(name = "capacidad_nominal", precision = 10, scale = 2)
    private BigDecimal capacidadNominal;

    @Lob
    @Column(name = "descripcion_detallada", columnDefinition = "TEXT")
    private String descripcionDetallada;

    @Column(name = "ficha_tecnica_url", length = 255)
    private String fichaTecnicaUrl;

    @Column(name = "imagen_url", length = 255)
    private String imagenUrl;
}
