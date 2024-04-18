package org.dive;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("org.dive")
@EnableWebMvc
@Configuration
public class AppConfig {
}
