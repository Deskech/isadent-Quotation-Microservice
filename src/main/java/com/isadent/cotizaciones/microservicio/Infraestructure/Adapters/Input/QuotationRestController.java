package com.isadent.cotizaciones.microservicio.Infraestructure.Adapters.Input;

import com.isadent.cotizaciones.microservicio.Application.Dtos.NewQuotation;
import com.isadent.cotizaciones.microservicio.Application.Services.NewCotizacionMaker;
import com.isadent.cotizaciones.microservicio.Domain.Model.IsadentQuotation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller receives a new quotation request
 */
@RestController

public class QuotationRestController {
    private final NewCotizacionMaker newCotizacionMaker;

    public QuotationRestController(NewCotizacionMaker newCotizacionMaker){
        this.newCotizacionMaker = newCotizacionMaker;
    }

    /**
     *
     * @param newQuotation includes the dental procedures, patient's name, and the patient's payment
     * @return a new Quotation ready to be converted to pdf or view
     */
    @CrossOrigin
    @PostMapping("/Quotation")
    public IsadentQuotation crearNewCotizacionIsadent(@RequestBody NewQuotation newQuotation){
        return newCotizacionMaker.makeNewCotizacion(newQuotation);
    }
}
