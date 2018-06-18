package kr.leocat.test.sample.rabbitmq.deadletter.spring;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleListener {

    @RabbitListener(queues = "q1")
    @RabbitHandler
    public void onMessage(Message message) {
        System.out.println(" [x] Received '" + new String(message.getBody()) + "'");
        printHeaders(message.getMessageProperties());

        // message reject
        throw new AmqpRejectAndDontRequeueException("ABCD");
    }

    private void printHeaders(MessageProperties properties) {
        System.out.println("  HEADERS " + properties.getHeaders().size());
        properties.getHeaders().forEach((key, value) -> {
            System.out.println("      " + key + ":" + value);
        });
    }

}
