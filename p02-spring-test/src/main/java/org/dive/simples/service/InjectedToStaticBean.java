package org.dive.simples.service;

import org.springframework.stereotype.Component;

@Component
public class InjectedToStaticBean {
    static {
        System.out.println("InjectedToStaticBean.static initializer");
    }

    public void test() {
        System.out.println("InjectedToStaticBean.test()");
    }
}
