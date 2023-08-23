package de.starwit.example.beandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConfiguredBean {
    
    private Logger log = LoggerFactory.getLogger(ConfiguredBean.class); 

    public void init() {
        log.info("Configured Bean is about to initialized");
    }
}
