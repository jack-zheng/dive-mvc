package org.dive.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ParentInjectTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        Child child = ctx.getBean(Child.class);

        child.printParentService();
        child.printService();
    }
}
