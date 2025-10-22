package com.proyecto_Web.repo;

import com.proyecto_Web.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MaterialRepo extends JpaRepository<Material, Integer> {

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
