package org.dive;

import org.dive.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("org.dive")
@EnableWebMvc
public class AppConfig {
    @Bean
    @RequestScope
    public User requestUser() {
        return new User(1, "Request User");
    }

    @Bean
    @SessionScope
    public User sessionUser() {
        return new User(2, "Session User");
    }

    @Bean
    @ApplicationScope
    public User appUser() {
        return new User(3, "App User");
    }
}
