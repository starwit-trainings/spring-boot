package de.starwit.rabbitmq;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

  private Logger log = LoggerFactory.getLogger(Receiver.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(String message) {
    log.info(message);
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

  @RabbitListener(queues = {"${rabbitmq.orderqueue}"})
  public void processOrders(String message) {
    log.info(message);
    /*
     * TODO
     * receive/deserialize Cart object
     * write to database
     * don't forget to validate and to add reception date
     */
  }

}