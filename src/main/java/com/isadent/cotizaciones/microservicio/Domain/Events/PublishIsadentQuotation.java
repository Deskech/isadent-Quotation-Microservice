package com.isadent.cotizaciones.microservicio.Domain.Events;

/**
 * Interface for publishing Isadent quotations to the Bill microservice.
 */
public interface PublishIsadentQuotation<T> {
    /**
     * Publishes the given Isadent quotation.
     *
     * @param isadentQuotation the Isadent quotation to publish
     */
    void publishQuotation(T isadentQuotation);
}
