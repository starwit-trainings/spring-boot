package de.starwit.example.beandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class SimpleComponent {
    
    private Logger log = LoggerFactory.getLogger(SimpleComponent.class);  

    @Autowired
    SimpleBean sBean;
    
    @Autowired
    ConfiguredBean cBean;

    @PostConstruct
    public void doStuffOnStartup() {
        log.info("Bean constructed");
        sBean.doSomething();
    }
}
