package com.isadent.cotizaciones.microservicio.Application.Services;

import com.isadent.cotizaciones.microservicio.Application.Dtos.NewQuotation;
import com.isadent.cotizaciones.microservicio.Domain.BussinesLogic.NewIsadentQuotation;
import com.isadent.cotizaciones.microservicio.Domain.Model.IsadentQuotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for creating a new Isadent quotation.
 */
@Service
public class NewCotizacionMaker {
    private final NewIsadentQuotation<NewQuotation> newIsadentQuotation;
    @Autowired
    public NewCotizacionMaker(NewIsadentQuotation<NewQuotation> newIsadentQuotation){
        this.newIsadentQuotation = newIsadentQuotation;
    }
    /**
     * Creates a new Isadent quotation based on the provided NewQuotation.
     *
     * @param newQuotation the new quotation data
     * @return the newly created Isadent quotation
     */

    public IsadentQuotation makeNewCotizacion(NewQuotation newQuotation) {
        return newIsadentQuotation.createNewIsadentQuotation(newQuotation);
    }
}
