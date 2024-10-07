package com.isadent.cotizaciones.microservicio.Infraestructure.Adapters.Output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadent.cotizaciones.microservicio.Domain.Events.PublishIsadentQuotation;
import com.isadent.cotizaciones.microservicio.Domain.Model.PublishedQuotation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * This Component sends Quotations to the Bill microservice
 */
@Component
public class RabbitMqSenderQuotation implements PublishIsadentQuotation<PublishedQuotation> {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    public RabbitMqSenderQuotation(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper){
        this.rabbitTemplate= rabbitTemplate;
        this.objectMapper= objectMapper;
    }

    /**
     *
     * @param isadentQuotation the Isadent quotation to publish
     */
    @Override
    public void publishQuotation(PublishedQuotation isadentQuotation) {
        try {
            String cotizacionPublicada = objectMapper.writeValueAsString(isadentQuotation);
            rabbitTemplate.convertAndSend("newEvent","cotizacion", cotizacionPublicada);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
