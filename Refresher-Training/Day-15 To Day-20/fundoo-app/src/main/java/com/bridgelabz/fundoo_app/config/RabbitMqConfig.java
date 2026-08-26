package com.bridgelabz.fundoo_app.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String EXCHANGE_NAME = "notes-exchange";
    public static final String COLLABORATOR_QUEUE = "collaborator-notify-queue";
    public static final String ACTIVITY_LOG_QUEUE = "activity-log-queue";
    public static final String ROUTING_KEY = "note.shared";

    public static final String DELETE_EXCHANGE_NAME = "notes-delete-exchange";
    public static final String CLEANUP_QUEUE = "cleanup-queue";
    public static final String AUDIT_LOG_QUEUE = "audit-log-queue";

    @Bean
    public TopicExchange notesExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue collaboratorQueue() {
        return new Queue(COLLABORATOR_QUEUE);
    }

    @Bean
    public Queue activityLogQueue() {
        return new Queue(ACTIVITY_LOG_QUEUE);
    }

    @Bean
    public Binding bindingCollaborator(Queue collaboratorQueue, TopicExchange notesExchange) {
        return BindingBuilder.bind(collaboratorQueue).to(notesExchange).with(ROUTING_KEY);
    }

    @Bean
    public Binding bindingActivityLog(Queue activityLogQueue, TopicExchange notesExchange) {
        return BindingBuilder.bind(activityLogQueue).to(notesExchange).with("note.*");
    }

    @Bean
    public FanoutExchange deleteExchange() {
        return new FanoutExchange(DELETE_EXCHANGE_NAME);
    }

    @Bean
    public Queue cleanupQueue() {
        return new Queue(CLEANUP_QUEUE);
    }

    @Bean
    public Queue auditLogQueue() {
        return new Queue(AUDIT_LOG_QUEUE);
    }

    @Bean
    public Binding bindingCleanup(Queue cleanupQueue, FanoutExchange deleteExchange) {
        return BindingBuilder.bind(cleanupQueue).to(deleteExchange);
    }

    @Bean
    public Binding bindingAudit(Queue auditLogQueue, FanoutExchange deleteExchange) {
        return BindingBuilder.bind(auditLogQueue).to(deleteExchange);
    }
}
