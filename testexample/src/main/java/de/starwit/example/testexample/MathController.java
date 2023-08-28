package de.starwit.example.testexample;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {
    
    @GetMapping("/add")
    float add(@RequestParam float a, @RequestParam float b) {
        return a + b;
    }

    @GetMapping("/add-exact")
    String addExact(@RequestParam String a, @RequestParam String b) {
        return new BigDecimal(a).add(new BigDecimal(b)).toString();
    }
}
