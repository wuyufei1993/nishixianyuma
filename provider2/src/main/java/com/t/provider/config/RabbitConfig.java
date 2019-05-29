package com.t.provider.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String TEST_QUEUE = "test_queue";

    @Bean
    public Queue queue() {
        return new Queue(TEST_QUEUE);
    }
}
