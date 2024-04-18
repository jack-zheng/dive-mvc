package org.dive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("============== start debug ==============");
        ServiceA serviceA = (ServiceA) context.getBean("serviceA");

//        System.out.println(serviceA.getClass());
        serviceA.test();
    }
}
