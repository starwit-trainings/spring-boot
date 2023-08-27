package de.starwit.example.jdbcexample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class MyService {

    private Logger log = LoggerFactory.getLogger(MyService.class);

    @Autowired
    MyUserRepository repo;

    @PostConstruct
    public void doStuffOnStartup() {
        log.debug("Initing service");
        MyUser u = new MyUser();
        u.setName("Hans Meiser");
        u.setEmail("hans@meiser.de");
        repo.save(u);
    }    

    public void testUser() {
        List<MyUser> users = repo.findAll();
        for (MyUser myUser : users) {
            log.debug("Found user " + myUser.getName());
        }
    }
}
