package org.dive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.getBean(TargetClass.class).doSomething();
        ctx.getBean(TargetClass.class).doSomethingElse();


        ((Timer) ctx.getBean("targetClass")).logTime();
    }
}