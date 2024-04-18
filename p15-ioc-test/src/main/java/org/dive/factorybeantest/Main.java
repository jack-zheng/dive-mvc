package org.dive.factorybeantest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(ctx.getBean("myServiceFactoryBean"));
//        System.out.println(ctx.getBean("abc"));

        TimeUnit.SECONDS.sleep(3);
        System.out.println(ctx.getBean("myServiceFactoryBean"));
    }
}
