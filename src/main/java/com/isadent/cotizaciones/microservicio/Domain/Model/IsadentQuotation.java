package com.isadent.cotizaciones.microservicio.Domain.Model;


import lombok.Getter;
import lombok.Setter;
import java.util.List;
/**
 * Represents an Isadent quotation, including details about dental procedures and prices,
 * payment information, and patient details.
 */
@Getter
@Setter
public class IsadentQuotation {
    private List<ImprovementPlan> improvementPlan;// includes dental procedures and prices in a list
    private String payment; // patient's payment
    private String patientName;// patient's name
    private String total;// Quotation's total amount
    private String paymentDate;
    public IsadentQuotation(){}

}

