package de.starwit.websockets_demo.stomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTriggerController {

    @Autowired
    private SimpMessagingTemplate template;

    @GetMapping("/trigger")
    public void trigger() {
        this.template.convertAndSend("/topic/location", new LocationMessage(52.0, 10.0, "location"));
    }
}
