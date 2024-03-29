package org.dive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        DaoService service = ctx.getBean(DaoService.class);
        service.createStudent(new Student("john", "1234"));

        System.out.println(service.getStudentByUsername("john"));
    }
}