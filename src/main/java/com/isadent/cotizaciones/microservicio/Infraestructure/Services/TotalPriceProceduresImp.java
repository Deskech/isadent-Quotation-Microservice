package com.isadent.cotizaciones.microservicio.Infraestructure.Services;

import com.isadent.cotizaciones.microservicio.Domain.BussinesLogic.TotalPriceProcedures;
import org.springframework.stereotype.Component;

@Component
public class TotalPriceProceduresImp implements TotalPriceProcedures {

    @Override
    public Double procedimietoTotal(Double precio, Double abono) {
        return precio - abono;
    }
}
