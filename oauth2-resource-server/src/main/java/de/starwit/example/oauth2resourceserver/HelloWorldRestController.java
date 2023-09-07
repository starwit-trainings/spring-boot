package de.starwit.example.oauth2resourceserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping("/public-endpoint")
    public String publicEndpoint() {
        return "Nothing interesting to see here, please continue.";
    }

    @GetMapping("/protected-endpoint")
    public String protectedEndpoint() {
        return "Just between you and me... \"Hello World :)\"";
    }

}