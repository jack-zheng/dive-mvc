package org.dive.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

class ProxyBeanTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(ctx.getBean(ProxyBean.class));
        System.out.println(ctx.getBean(ProxyBean.class));
    }
}

@ComponentScan("org.dive.proxy")
class Config {
}