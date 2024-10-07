package com.isadent.cotizaciones.microservicio.Infraestructure.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the improvement plans stored in the database
 */
@Entity
@Table(name = "precios")
@Getter
@Setter
public class Prices {
    @Id
    @Column(name="id")
    private int id;
    @Column(name = "procedimiento")
    private String dentalProcedures;
    @Column(name = "precio")
    private Double prices;
}

