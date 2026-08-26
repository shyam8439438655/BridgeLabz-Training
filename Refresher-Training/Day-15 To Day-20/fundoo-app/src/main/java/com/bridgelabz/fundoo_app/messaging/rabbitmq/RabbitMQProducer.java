package com.bridgelabz.fundoo_app.messaging.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

    @Autowired(required = false)
    private RabbitTemplate rabbitTemplate;

    public void sendShareEvent(String message) {
        if (rabbitTemplate != null) {
            try {
                rabbitTemplate.convertAndSend("notes-exchange", "note.shared", message);
            } catch (Exception e) {
                // Ignore or log
            }
        }
    }

    public void sendDeleteEvent(String message) {
        if (rabbitTemplate != null) {
            try {
                rabbitTemplate.convertAndSend("notes-delete-exchange", "", message);
            } catch (Exception e) {
                // Ignore or log
            }
        }
    }
}
