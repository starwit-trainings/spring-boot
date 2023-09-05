package de.starwit.example.testexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Service
public class SampleService {

    private Logger log = LoggerFactory.getLogger(SampleService.class);
    
    @Autowired
    protected ObjectMapper mapper;

    @PostConstruct
    public void testThings() {
        MyUser u = new MyUser();
        u.setEmail("test@mail.de");
        u.setName("Test");

        try {
            String json = mapper.writeValueAsString(u);
            log.info("Serialized object " + json);

            MyUser parsedUser = mapper.readValue(json, MyUser.class);
        } catch (JsonProcessingException e) {
            log.info("Can't serialize " + e.getMessage());
        }
    }
}
