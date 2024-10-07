package com.isadent.cotizaciones.microservicio.Infraestructure.Services;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * Provides the QuotationDate interface with details
 */
@Component
public class QuotationDateImp implements QuotationDate {
    /**
     *
     * @return a today formatted date
     */
    @Override
    public String createQuotationDate() {
        DateTimeFormatter todayDate = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(" de ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(",")
                .appendText(ChronoField.YEAR)
                .toFormatter(new Locale("ES","ES"));

        LocalDateTime now = LocalDateTime.now();
        return now.format(todayDate);
    } 
}
