package com.isadent.cotizaciones.microservicio.Domain.BussinesLogic;


import com.isadent.cotizaciones.microservicio.Domain.Model.IsadentQuotation;
/**
 * Interface for creating a new Isadent quotation.
 */
public interface NewIsadentQuotation<T> {
     /**
      * Creates a new Isadent quotation based on the provided input.
      *
      * @param newQuotation the input data for creating the new quotation
      * @return the newly created Isadent quotation
      */
     IsadentQuotation createNewIsadentQuotation(T newQuotation);
}
