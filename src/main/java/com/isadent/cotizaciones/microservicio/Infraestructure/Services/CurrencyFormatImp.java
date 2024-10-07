package com.isadent.cotizaciones.microservicio.Infraestructure.Services;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Provides the details for the CurrencyFormat interface
 */
@Component
public class CurrencyFormatImp implements CurrencyFormat {
    private final NumberFormat numberFormat= NumberFormat.getCurrencyInstance(Locale.US);

    /**
     *
     * @param price represents the value that we want to format
     * @return a string money formatted value
     */
    @Override
    public String createMoneyFormat(Double price) {
        return numberFormat.format(price);
    }
}
