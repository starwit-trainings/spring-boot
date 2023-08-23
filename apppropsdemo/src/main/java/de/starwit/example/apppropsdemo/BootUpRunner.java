package de.starwit.example.apppropsdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * This is an example, how a method can hook up into CLI vars.
 */

@Component
public class BootUpRunner implements CommandLineRunner {
  
    private Logger log = LoggerFactory.getLogger(BootUpRunner.class); 

    @Override
    public void run(String... args) {
        log.info("I am called on startup with args: "); 
        for (String string : args) {
            log.info(string); 
        }
    }
}
