package kr.leocat.test.sample.rabbitmq.deadletter.spring;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMqConfig {

    @Bean
    public FanoutExchange x1() {
        return new FanoutExchange("x1");
    }

    @Bean
    public FanoutExchange x2() {
        return new FanoutExchange("x2");
    }

    @Bean
    public Queue q1() {
        Map arguments = new HashMap();
        arguments.put("x-dead-letter-exchange", "x1");
        return new Queue("q1", false, false, false, arguments);
    }

    @Bean
    public Queue q2() {
        Map arguments = new HashMap();
        arguments.put("x-dead-letter-exchange", "x2");
        arguments.put("x-message-ttl", 5000L);
        return new Queue("q2", false, false, false, arguments);
    }

    @Bean
    public Binding bindingX1Q2(FanoutExchange x1, Queue q2) {
        return BindingBuilder.bind(q2)
                .to(x1);
    }

    @Bean
    public Binding bindingX2Q1(FanoutExchange x2, Queue q1) {
        return BindingBuilder.bind(q1)
                .to(x2);
    }

}
