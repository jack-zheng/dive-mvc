package org.dive;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("org.dive")
@EnableAspectJAutoProxy
@Configuration
public class Config {
}
