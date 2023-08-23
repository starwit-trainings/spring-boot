package de.starwit.example.beandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleBean {

    private Logger log = LoggerFactory.getLogger(SimpleBean.class);

    public SimpleBean() {
        log.info("If you want to initialize your bean, do it here.");
    }
    

    public void doSomething() {
        log.info("This method does something important");
    }
}
