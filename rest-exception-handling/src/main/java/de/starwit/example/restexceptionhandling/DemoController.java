package de.starwit.example.restexceptionhandling;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/add-ints")
    public int addInts(@RequestParam String a, @RequestParam String b) {
        return Integer.valueOf(a) + Integer.valueOf(b);
    }
    
}
