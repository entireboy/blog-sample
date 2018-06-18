package kr.leocat.test.sample.rabbitmq.deadletter.client;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DeadLetterSample {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection("localhost:5672");
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("x1", "fanout", false);
        channel.exchangeDeclare("x2", "fanout", false);

        Map props1 = new HashMap();
        props1.put("x-dead-letter-exchange", "x1");
        channel.queueDeclare("q1", false, false, false, props1);

        Map props2 = new HashMap();
        props2.put("x-dead-letter-exchange", "x2");
        props2.put("x-message-ttl", 5000L);
        channel.queueDeclare("q2", false, false, false, props2);

        channel.queueBind("q2", "x1", "");
        channel.queueBind("q1", "x2", "");


        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");

                // requeue=false
                channel.basicNack(envelope.getDeliveryTag(), true, false);
//                channel.basicReject(envelope.getDeliveryTag(), false);
                System.out.println("    Message is rejected: " + message);
            }
        };

        // auto ack=false
        channel.basicConsume("q1", false, consumer);
        channel.basicPublish("", "q1", null, "AA".getBytes());
    }

}
