package org.dive.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class TestImportAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigB.class);
        System.out.println(ctx.getBean("a"));
        System.out.println(ctx.getBean("b"));
    }

}

@Configuration
class ConfigA {
    @Bean
    public A a() {
        return new A();
    }
}

//@Configuration
@Import(ConfigA.class)
class ConfigB {
    @Bean
    public B b() {
        return new B();
    }
}

// create test class A
class A {
    public void print() {
        System.out.println("A");
    }
}

// create test class B
class B {
    public void print() {
        System.out.println("B");
    }
}