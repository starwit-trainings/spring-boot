package de.starwit.example.beandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MyComponent {
    
    private Logger log = LoggerFactory.getLogger(MyComponent.class);  

    @Autowired
    SimpleBean sBean;   

    @PostConstruct
    public void doStuffOnStartup() {
        log.info("Bean constructed");
        sBean.doSomething();
    }
}
