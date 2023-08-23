package de.starwit.example.beandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupInitComponent {
    
    private Logger log = LoggerFactory.getLogger(StartupInitComponent.class);  

    public static int counter = 0;;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Increment counter " + counter);
        Object source = event.getSource();
        log.info(source.getClass().toString());
        counter++;
    }    
}
