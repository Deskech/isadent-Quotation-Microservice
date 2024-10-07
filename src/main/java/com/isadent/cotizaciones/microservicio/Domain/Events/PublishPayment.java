package com.isadent.cotizaciones.microservicio.Domain.Events;

import com.isadent.cotizaciones.microservicio.Domain.Model.Payment;
/**
 * Interface for publishing payment events.
 */
public interface PublishPayment {
    /**
     * Publishes a new payment event.
     *
     * @param newPayment the payment to be published
     */
    void publishNewPayment(Payment newPayment);
}
