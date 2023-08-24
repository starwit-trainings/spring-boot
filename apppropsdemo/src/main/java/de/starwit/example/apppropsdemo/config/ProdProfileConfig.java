package de.starwit.example.apppropsdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import de.starwit.example.apppropsdemo.ProfiledBean;

@Profile("prod")
@Configuration
public class ProdProfileConfig {

    @Value("${anysystem.username}")
    private String username;

    @Value("${anysystem.password}")
    private String password;

    @Value("${anysystem.url}")
    private String url;


    @Bean(name = "ProfiledBean")
    public ProfiledBean getProfiledBean() {
        ProfiledBean bean = new ProfiledBean();
        bean.setEncrypted(true);
        bean.setUsername(username);
        bean.setPassword(password);
        bean.setUrl(url);

        return bean;
    }
}
