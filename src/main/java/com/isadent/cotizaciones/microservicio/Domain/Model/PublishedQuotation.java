package com.isadent.cotizaciones.microservicio.Domain.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
/**
 * Represents a published quotation for a patient, including details of the improvement plan,
 * payment information, and the total amount.
 */
@EqualsAndHashCode
@Getter
public final class PublishedQuotation {
    private final List<ImprovementPlan> improvementPlan;
    private final Double payment;
    private final String patientName;
    private final Double total;
    private final String paymentDate;

    public PublishedQuotation(List<ImprovementPlan> improvementPlan, Double payment, String patientName, Double total, String paymentDate){
        this.improvementPlan = improvementPlan;
        this.payment = payment;
        this.patientName = patientName;
        this.total= total;
        this.paymentDate = paymentDate;
    }


}
