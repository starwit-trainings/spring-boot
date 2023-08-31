package de.starwit.example.gradledemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MyComponent {
    
    private Logger log = LoggerFactory.getLogger(MyComponent.class); 

    @PostConstruct
    public void constructMyComponent() {
        log.info("Constructing Component");
    }
}
