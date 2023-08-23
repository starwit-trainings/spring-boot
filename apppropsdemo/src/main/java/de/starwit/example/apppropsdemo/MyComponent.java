package de.starwit.example.apppropsdemo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MyComponent {

    private Logger log = LoggerFactory.getLogger(MyComponent.class);
    
    @Autowired
    private Environment env; 

    @Value( "${avalue}" )
    private String aValue;

     @PostConstruct
    public void doStuffOnStartup() {
        log.info("Bean constructed");
        
        log.info("Value via annotation " + aValue);
        log.info("Value via environment " + env.getProperty("avalue"));

        log.info(Arrays.asList(env.getActiveProfiles()).toString());
    }   
}
