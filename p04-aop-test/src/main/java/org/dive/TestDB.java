package org.dive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDB {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(H2Config.class);
        StudentService service = ctx.getBean(StudentService.class);

        System.out.println(service.save(new Student("jack", "pwd123")));

    }
}
