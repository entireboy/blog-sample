package kr.leocat.test.sample.rabbitmq.deadletter.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeadLetterSampleApp implements CommandLineRunner {

    @Autowired
    private SimplePublisher publisher;

    public static void main(String [] args) {
        SpringApplication.run(DeadLetterSampleApp.class, args);
    }

    @Override
    public void run(String ... args) {
        publisher.send("ABCD");
    }

}
