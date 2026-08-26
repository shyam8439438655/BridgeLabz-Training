package com.bridgelabz.fundoo_app.messaging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReminderProducer {

    @Autowired(required = false)
    private JmsTemplate jmsTemplate;

    public void sendReminder(String message) {
        if (jmsTemplate != null) {
            try {
                jmsTemplate.convertAndSend("reminder-queue", message);
            } catch (Exception e) {
                // Ignore or log
            }
        }
    }

    public void sendPasswordReset(String email) {
        if (jmsTemplate != null) {
            try {
                jmsTemplate.convertAndSend("password-reset-queue", email);
            } catch (Exception e) {
                // Ignore or log
            }
        }
    }
}
