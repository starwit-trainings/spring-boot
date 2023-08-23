package de.starwit.example.beandemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeandemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeandemoApplication.class, args);
	}

	@Bean
	public SimpleBean getSimpleBean() {
		return new SimpleBean();
	}
}
