package org.dive;

import org.dive.service.Config;
import org.dive.spring.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ApplicationContext(Config.class);

        System.out.println("-----------------");
        System.out.println(ctx.getBean("userService"));
        System.out.println(ctx.getBean("userService"));
    }
}