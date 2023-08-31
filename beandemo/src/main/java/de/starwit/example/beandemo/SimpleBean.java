package de.starwit.example.beandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class SimpleBean {

    private Logger log = LoggerFactory.getLogger(SimpleBean.class);

    @Value("MyDefaultName")
    private String name;
    
    private int age;

    public SimpleBean() {
        log.info("If you want to initialize your bean, do it here.");
        log.info("Values at constructor time " + this.toString());
    }

    public void init() {
        log.info("This is another method to init your bean.");
        log.info("Values at init time " + this.toString());
    }

    public void doSomething() {
        log.info("This method does something important");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + 
        " [" + this.name + ", " + this.age + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }    
}
