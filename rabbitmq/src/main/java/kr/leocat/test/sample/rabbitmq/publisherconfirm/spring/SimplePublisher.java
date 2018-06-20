package kr.leocat.test.sample.rabbitmq.publisherconfirm.spring;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimplePublisher {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue q1;

    public void send(String message) {
        template.convertAndSend(q1.getName(), message);
    }

}
