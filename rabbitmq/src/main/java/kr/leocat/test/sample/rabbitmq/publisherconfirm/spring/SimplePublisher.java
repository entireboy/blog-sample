package kr.leocat.test.sample.rabbitmq.publisherconfirm.spring;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SimplePublisher {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue q1;

    @PostConstruct
    private void configPublisherConfirm() {
        template.setConfirmCallback((correlationData, ack, cause) -> {
            if(ack) {
                System.out.println("ACK");
            } else {
                System.out.println("NACK: " + cause);
            }
        });
    }

    public void send(String message) {
        template.convertAndSend(q1.getName(), message);
    }

}
