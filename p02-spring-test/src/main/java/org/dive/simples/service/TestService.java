package org.dive.simples.service;

import org.springframework.stereotype.Component;

@Component
public class TestService {
    static {
        System.out.println("------ TestService.static initializer");
    }
    public void test() {
        System.out.println("TestService.test()");
        TestUtilsClass.test();
    }
}
