package com.isadent.cotizaciones.microservicio.Infraestructure.Services;

/**
 * This interface provides a money format to numbers
 */
public interface CurrencyFormat {
    /**
     *
     * @param precio represents the value that we want to format
     * @return String monet formatted value
     */
    String createMoneyFormat(Double precio);
}
