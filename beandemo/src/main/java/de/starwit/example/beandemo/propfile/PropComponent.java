package de.starwit.example.beandemo.propfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@PropertySource("classpath:test.properties")
public class PropComponent {

    private Logger log = LoggerFactory.getLogger(PropComponent.class);
    
    @Value("${name}")
    private String name;

    @Value("${email}")
    private String email;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + 
        " [" + this.name + ", " + this.email + "]";
    }

    @PostConstruct
    public void checkContent() {
        log.info("PropComponent build with " + toString());
    }

}
