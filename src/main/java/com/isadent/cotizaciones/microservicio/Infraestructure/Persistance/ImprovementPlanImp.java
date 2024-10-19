package com.isadent.cotizaciones.microservicio.Infraestructure.Persistance;

import com.isadent.cotizaciones.microservicio.Application.Dtos.NewQuotation;
import com.isadent.cotizaciones.microservicio.Domain.Model.DentalProcedure;
import com.isadent.cotizaciones.microservicio.Domain.Model.ImprovementPlan;
import com.isadent.cotizaciones.microservicio.Domain.Repository.ImprovementPlanRepository;
import com.isadent.cotizaciones.microservicio.Infraestructure.Entities.Prices;
import com.isadent.cotizaciones.microservicio.Infraestructure.Mappers.IsadentQuotationMapper;
import com.isadent.cotizaciones.microservicio.Infraestructure.Repository.ImprovementPlanJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Provides the interface with details
 */
@Component
public class ImprovementPlanImp implements ImprovementPlanRepository<NewQuotation> {
    private final ImprovementPlanJpaRepository improvementPlanJpaRepository;
    private final IsadentQuotationMapper isaDentQuotationMapper;

    public ImprovementPlanImp(ImprovementPlanJpaRepository improvementPlanJpaRepository, IsadentQuotationMapper isaDentQuotationMapper) {
        this.improvementPlanJpaRepository = improvementPlanJpaRepository;
        this.isaDentQuotationMapper = isaDentQuotationMapper;
    }

    /**
     * @param improvementPlan references the patient's dental procedures
     * @return a list of Improvement Plan object ready for user presentation
     */
    @Override
    public List<ImprovementPlan> getImprovementPlan(NewQuotation improvementPlan) {
        List<String> procedures = improvementPlan.getDentalProcedure().stream().map(DentalProcedure::getDentalProcedure).toList();
        List<Prices> jpaModel = improvementPlanJpaRepository.getImprovementPlan(procedures);
        return isaDentQuotationMapper.toDomain(jpaModel);
    }

}
