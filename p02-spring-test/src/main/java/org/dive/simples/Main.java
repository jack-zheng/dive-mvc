package org.dive.simples;

import org.dive.simples.service.SpringContextHolder;
import org.dive.simples.service.TestService;
import org.dive.simples.service.TestUtilsClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        TestService service = ctx.getBean(TestService.class);

        System.out.println("-------- After getBean");
        service.test();

//        System.out.println("-------- After test");
//        TestUtilsClass testUtilsClass = ctx.getBean(TestUtilsClass.class);
//        System.out.println(testUtilsClass);

        System.out.println("-------- Test context holder");
//        SpringContextHolder.applicationContext.getBean(TestService.class).test();
    }
}