package de.starwit.websockets_demo.stomp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private SimpMessagingTemplate template;
    
    @MessageMapping("/location")
    @SendTo("/topic/location")
    public LocationMessage sendLocationMessage(String incomingMessage) {
        log.info("Received message: " + incomingMessage);
        return new LocationMessage(52.0, 10.0, "location");
    }  
}
