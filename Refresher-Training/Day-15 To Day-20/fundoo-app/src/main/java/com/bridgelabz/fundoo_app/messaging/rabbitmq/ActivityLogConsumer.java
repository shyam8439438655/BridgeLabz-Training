package com.bridgelabz.fundoo_app.messaging.rabbitmq;

import com.bridgelabz.fundoo_app.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActivityLogConsumer {

    @RabbitListener(queues = RabbitMqConfig.ACTIVITY_LOG_QUEUE)
    public void logActivity(String message) {
        log.info("RabbitMQ Activity Log Consumer: Received shared event -> {}", message);
    }

    @RabbitListener(queues = RabbitMqConfig.CLEANUP_QUEUE)
    public void cleanupDeletedNote(String message) {
        log.info("RabbitMQ Cleanup Consumer: Deleting note resources forever -> {}", message);
    }

    @RabbitListener(queues = RabbitMqConfig.AUDIT_LOG_QUEUE)
    public void auditDeletedNote(String message) {
        log.info("RabbitMQ Audit Consumer: Auditing deletion of note -> {}", message);
    }
}
