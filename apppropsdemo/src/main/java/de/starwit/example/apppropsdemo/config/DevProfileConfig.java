package de.starwit.example.apppropsdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import de.starwit.example.apppropsdemo.ProfiledBean;

@Profile("dev")
@Configuration
public class DevProfileConfig {

    @Value("${anysystem.url}")
    private String url;

    @Bean(name = "ProfiledBean")
    public ProfiledBean getProfiledBean() {
        ProfiledBean bean = new ProfiledBean();
        bean.setPassword("dev");
        bean.setUsername("dev");
        bean.setUrl(url);
        
        return bean;
    }
}
