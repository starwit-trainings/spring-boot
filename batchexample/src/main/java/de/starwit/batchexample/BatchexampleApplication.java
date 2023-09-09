package de.starwit.batchexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchexampleApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(BatchexampleApplication.class, args)));
	}

}
