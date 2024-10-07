package com.isadent.cotizaciones.microservicio.Infraestructure.Mappers;


import com.isadent.cotizaciones.microservicio.Domain.Model.ImprovementPlan;
import com.isadent.cotizaciones.microservicio.Infraestructure.Entities.Prices;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The implementation of the Isadent Quotation mapper
 */
@Component
public class IsaDentQuotationMapperImp implements IsadentQuotationMapper {
    /**
     *
     * @param prices jpa entity containing dental procedures and prices
     * @return a list of improvement plan object
     */
    @Override
    public List<ImprovementPlan> toDomain(List<Prices> prices) {
        return prices.stream().map(
                prices1 -> new ImprovementPlan(prices1.getDentalProcedures(), prices1.getPrices())).collect(Collectors.toList());
    }
}
