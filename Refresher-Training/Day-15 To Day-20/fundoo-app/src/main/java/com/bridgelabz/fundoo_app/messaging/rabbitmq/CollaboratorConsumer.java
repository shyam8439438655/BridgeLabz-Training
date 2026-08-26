package com.bridgelabz.fundoo_app.messaging.rabbitmq;

import com.bridgelabz.fundoo_app.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CollaboratorConsumer {

    @RabbitListener(queues = RabbitMqConfig.COLLABORATOR_QUEUE)
    public void notifyCollaborator(String message) {
        log.info("RabbitMQ Collaborator Notify Consumer: Received shared event -> {}", message);
    }
}
