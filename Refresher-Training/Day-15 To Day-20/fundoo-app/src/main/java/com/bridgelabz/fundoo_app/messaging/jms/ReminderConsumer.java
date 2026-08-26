package com.bridgelabz.fundoo_app.messaging.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReminderConsumer {

    @JmsListener(destination = "reminder-queue")
    public void receiveReminder(String message) {
        log.info("Received JMS Reminder Message asynchronously: {}", message);
        try {
            // Simulate processing delay
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Processed JMS Reminder: {}", message);
    }

    @JmsListener(destination = "password-reset-queue")
    public void receivePasswordReset(String email) {
        log.info("Received JMS Password Reset request asynchronously for email: {}", email);
        try {
            // Simulate sending recovery email
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Processed Password Reset email sent to: {}", email);
    }
}
