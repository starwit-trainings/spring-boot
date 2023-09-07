package de.starwit.example.oauth2resourceserver;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping("/public-endpoint")
    public String publicEndpoint() {
        return "Nothing interesting to see here, please continue.";
    }

    @GetMapping("/protected-endpoint")
    public String protectedEndpoint(AbstractOAuth2TokenAuthenticationToken<?> authToken) {
        String username = (String) authToken.getTokenAttributes().get("preferred_username");
        List<String> authorities = authToken.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        return String.format("Hi %s\nJust between you and me... \"Hello World :)\"\n\nP.S.: You have the following roles %s", username, authorities);
    }

    @GetMapping("/admin-endpoint")
    public String adminEndpoint() {
        return "With great power comes great responsibility.";
    }

}