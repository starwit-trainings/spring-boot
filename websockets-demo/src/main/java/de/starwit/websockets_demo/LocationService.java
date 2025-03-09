package de.starwit.websockets_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

@Service
public class LocationService {

    private Logger log = LoggerFactory.getLogger(LocationService.class);
    
    public void sendLocationStream(WebSocketSession session) {
        int i = 0;
        while(session.isOpen() & i < 10) {
            try {
                Thread.sleep(1000);
                session.sendMessage(new TextMessage("Location update"));
            } catch (Exception e) {
                log.error("Error sending location update: " + e.getMessage());
            }
            i++;
        }
    }
}
