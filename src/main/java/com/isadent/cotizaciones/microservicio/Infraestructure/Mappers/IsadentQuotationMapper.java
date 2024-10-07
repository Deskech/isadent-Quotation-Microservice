package com.isadent.cotizaciones.microservicio.Infraestructure.Mappers;


import com.isadent.cotizaciones.microservicio.Domain.Model.ImprovementPlan;
import com.isadent.cotizaciones.microservicio.Infraestructure.Entities.Prices;

import java.util.List;

/**
 * Maps a list of Prices ( jpa entity) into a domain List of ImprovementPlan.
 */
public interface IsadentQuotationMapper {
   /**
    *
    * @param prices jpa entity containing dental procedures and prices
    * @return a list of Improvement plan domain model with the same datas
    */
   List <ImprovementPlan> toDomain(List <Prices> prices);
}
