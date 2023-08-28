package de.starwit.example.beandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;


public class ConfiguredBean {
    
    private Logger log = LoggerFactory.getLogger(ConfiguredBean.class); 

    @Email
    private String email;

    @NotBlank
    private String aStructuredString;

    @Max(value = 10)
    private int aNumber;

    public void init() {
        log.info("Configured Bean is about to be initialized");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getaStructuredString() {
        return aStructuredString;
    }

    public void setaStructuredString(String aStructuredString) {
        this.aStructuredString = aStructuredString;
    }

    public int getaNumber() {
        return aNumber;
    }

    public void setaNumber(int aNumber) {
        this.aNumber = aNumber;
    }
}
