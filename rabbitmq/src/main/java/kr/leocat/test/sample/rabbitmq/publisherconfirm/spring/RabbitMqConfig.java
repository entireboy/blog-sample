package kr.leocat.test.sample.rabbitmq.publisherconfirm.spring;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost", 5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        // publisher confirm ON
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    public Queue q1() {
        return new Queue("q1", false, false, false, null);
    }

}
