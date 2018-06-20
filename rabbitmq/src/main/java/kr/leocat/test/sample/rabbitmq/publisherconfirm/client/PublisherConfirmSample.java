package kr.leocat.test.sample.rabbitmq.publisherconfirm.client;

import com.rabbitmq.client.*;

import java.io.IOException;

public class PublisherConfirmSample {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection("localhost:5672");
        Channel channel = connection.createChannel();

        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("ACK: " + deliveryTag);
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("NACK: " + deliveryTag);
            }
        });

        channel.queueDeclare("q1", false, false, false, null);

        channel.basicPublish("", "q1", null, "AA".getBytes());
        channel.basicPublish("", "q1", null, "BB".getBytes());
    }

}
