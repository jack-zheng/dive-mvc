package org.dive;

import org.dive.proxy.InnerBean;
import org.dive.proxy.OutBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.util.Date;

public class TestProxy {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ctx.getBean(OutBean.class).getInnerBean().test();
        Thread.sleep(1000);
        ctx.getBean(OutBean.class).getInnerBean().test();
    }
}

@ComponentScan("org.dive.proxy")
class Config {
    @Bean
    @Scope(value="prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public InnerBean innerBean() {
        return new InnerBean(new Date());
    }
}