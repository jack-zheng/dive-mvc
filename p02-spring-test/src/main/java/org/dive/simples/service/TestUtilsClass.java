package org.dive.simples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ReactiveAdapterRegistry;

public class TestUtilsClass {
    @Autowired
    private InjectedToStaticBean injectedToStaticBean;

    static {
        System.out.println("TestStaticClass.static initializer");
    }

    public static void test() {
        System.out.println("TestStaticClass.test()");
    }

    public void test2() {
        System.out.println(injectedToStaticBean);
    }
}
