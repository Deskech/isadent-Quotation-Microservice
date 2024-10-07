package com.isadent.cotizaciones.microservicio.Infraestructure.Repository;


import com.isadent.cotizaciones.microservicio.Infraestructure.Entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This repository searches in the database for the dental procedures prices
 */
@Repository
public interface ImprovementPlanJpaRepository extends JpaRepository<Prices, Integer> {

    @Query("SELECT p FROM Prices p WHERE p.dentalProcedures IN :dentalProcedures")
    List <Prices> getImprovementPlan(@Param("dentalProcedures") List <String> dentalProcedures);
}
