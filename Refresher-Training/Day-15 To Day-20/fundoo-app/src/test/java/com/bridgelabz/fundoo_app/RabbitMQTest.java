package com.bridgelabz.fundoo_app;

import com.bridgelabz.fundoo_app.messaging.rabbitmq.RabbitMQProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RabbitMQTest {

    @Autowired(required = false)
    private RabbitMQProducer rabbitMQProducer;

    @Test
    void testRabbitTemplateLoads() {
        assertNotNull(rabbitMQProducer, "RabbitMQProducer component should be registered in the Spring context");
    }
}
