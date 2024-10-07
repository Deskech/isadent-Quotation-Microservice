package com.isadent.cotizaciones.microservicio.Domain.Model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
/**
 * Represents a payment made by a patient.
 * This class encapsulates the details of the payment including the patient's name and the payment amount.
 */
@EqualsAndHashCode
@Getter
public final class Payment {

    private final String patientName;
    private final Double paymentValue;

    public Payment(String patientName, Double paymentValue) {
        this.patientName = patientName;
        this.paymentValue = paymentValue;
    }
}


