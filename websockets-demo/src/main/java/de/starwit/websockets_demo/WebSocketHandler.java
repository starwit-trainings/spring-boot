package de.starwit.websockets_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
public class WebSocketHandler extends TextWebSocketHandler {

    private Logger log = LoggerFactory.getLogger(WebSocketHandler.class);

    LocationService locationService;

    public WebSocketHandler(LocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("New WebSocket connection: " + session.getId());
        locationService.sendLocationStream(session);
    }  

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("Got Message " + message.getPayload());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("WebSocket connection closed: " + session.getId());
    }
}