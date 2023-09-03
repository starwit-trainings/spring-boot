package de.starwit.example.beandemo;

import jakarta.annotation.PostConstruct;

public class ScopedBean {
    
    private int number;

    @PostConstruct
    public void init() {
        number = (int) ((Math.random() * (500 - 1)) + 1);
    }

    public int getNumber() {
        return number;
    }
}
