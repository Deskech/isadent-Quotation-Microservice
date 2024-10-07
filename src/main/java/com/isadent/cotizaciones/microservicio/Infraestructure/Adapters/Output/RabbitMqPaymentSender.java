package com.isadent.cotizaciones.microservicio.Infraestructure.Adapters.Output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadent.cotizaciones.microservicio.Domain.Events.PublishPayment;
import com.isadent.cotizaciones.microservicio.Domain.Model.Payment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * This component publish Payments to the payments microservice
 */
@Component
public class RabbitMqPaymentSender implements PublishPayment {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    public RabbitMqPaymentSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper){
                this.rabbitTemplate = rabbitTemplate;
                this.objectMapper = objectMapper;
            }

    /**
     *
     * @param newPayment the payment to be published
     */
    @Override
    public void publishNewPayment(Payment newPayment) {

        try {
            String abonoPublicado= objectMapper.writeValueAsString(newPayment);
            rabbitTemplate.convertAndSend("newEvent","abono",abonoPublicado);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
