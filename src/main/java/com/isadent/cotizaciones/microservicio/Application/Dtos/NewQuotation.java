package com.isadent.cotizaciones.microservicio.Application.Dtos;

import com.isadent.cotizaciones.microservicio.Domain.Model.DentalProcedure;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewQuotation {
private String patientName;
private Double payment;
private List<DentalProcedure> dentalProcedure;

public NewQuotation(String patientName, Double payment, List<DentalProcedure> dentalProcedure){
    this.patientName= patientName;
    this.payment = payment;
    this.dentalProcedure = dentalProcedure;
}
}
