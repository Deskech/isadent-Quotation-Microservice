package com.isadent.cotizaciones.microservicio.Domain.Repository;

import com.isadent.cotizaciones.microservicio.Domain.Model.ImprovementPlan;

import java.util.List;

/**
 * Retrieves the dental procedures prices
 */
public interface ImprovementPlanRepository<T>{
  /**
   *
   * @param improvementPlan references the patient's dental procedures
   * @return list of dental procedures and prices
   */
  List <ImprovementPlan> getImprovementPlan(T improvementPlan);
}
