package de.starwit.securityredirect;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
//import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    private Logger log = LoggerFactory.getLogger(HelloWorldRestController.class);

    @GetMapping("/public-endpoint")
    public String publicEndpoint() {
        return "Nothing interesting to see here, please continue.";
    }

    @GetMapping("/protected-endpoint")
    public String protectedEndpoint() {
        
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        log.info(principal.toString());
        if (principal instanceof DefaultOidcUser) {
            username = ((DefaultOidcUser)principal).getPreferredUsername();
        } else {
            username = principal.toString();
        }

        StringBuffer sb = new StringBuffer("Hi ");
        sb.append(username);
        sb.append(",<br />");
        sb.append("You roles are: <br />");

        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            log.info(grantedAuthority.getAuthority().toString());
            sb.append(grantedAuthority.getAuthority().toString());
            sb.append("<br />");
        }

        return sb.toString();
    }

    @GetMapping("/protected-endpoint-with-role")
    public String protectedEndpointRole() {    
        return "If you see this, you have all necessary privileges";
    }

    @GetMapping("/protected-endpoint-annotation")
    @PreAuthorize("hasRole('ROLE_reader')")
    public String protectedEndpointAnnotation() {    
        return "If you see this, you have all necessary privileges";
    }


    @GetMapping("/admin-endpoint")
    public String adminEndpoint() {
        return "With great power comes great responsibility.";
    }

}