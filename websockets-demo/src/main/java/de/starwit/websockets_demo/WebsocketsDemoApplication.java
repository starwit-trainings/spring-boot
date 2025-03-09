package de.starwit.websockets_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@SpringBootApplication
@EnableWebSocket
public class WebsocketsDemoApplication implements WebSocketConfigurer {

    @Autowired
    LocationService locationService;

    public static void main(String[] args) {
        SpringApplication.run(WebsocketsDemoApplication.class, args);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketHandler(locationService), "/websocket")
                .setAllowedOrigins("*");
    }
}
