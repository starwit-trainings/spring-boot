package de.starwit.rabbitmq;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sender implements CommandLineRunner {
    
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    @Value("rabbitmq.topicname")
    private String topicExchangeName;
  
    public Sender(Receiver receiver, RabbitTemplate rabbitTemplate) {
      this.receiver = receiver;
      this.rabbitTemplate = rabbitTemplate;
    }
  
    @Override
    public void run(String... args) throws Exception {
      System.out.println("Sending message...");
      rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
      receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }    

}
