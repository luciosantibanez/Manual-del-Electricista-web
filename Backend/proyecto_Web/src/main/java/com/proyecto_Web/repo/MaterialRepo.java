package com.proyecto_Web.repo;

import com.proyecto_Web.domain.Material;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MaterialRepo extends JpaRepository<Material,Integer> {

    @Query("""
        SELECT m FROM Material m
        WHERE LOWER(m.nombre)        LIKE LOWER(CONCAT('%', :q, '%'))
           OR LOWER(m.marca)         LIKE LOWER(CONCAT('%', :q, '%'))
           OR LOWER(m.modelo)        LIKE LOWER(CONCAT('%', :q, '%'))
           OR LOWER(m.tipoMaterial)  LIKE LOWER(CONCAT('%', :q, '%'))
    """)
    List<Material> search(@Param("q") String q);

    List<Material> findByTipoMaterialIgnoreCase(String tipoMaterial);
}
