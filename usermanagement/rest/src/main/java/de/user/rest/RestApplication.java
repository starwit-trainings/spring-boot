package de.user.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Base RestApplication
 *
 * Disable default HATEOAS with exclude <code>org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration</code>
 *
 */
@SpringBootApplication(scanBasePackages = { "de.user.rest", "de.user.service", "de.user.persistence", "de.user.application.config"})
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}
