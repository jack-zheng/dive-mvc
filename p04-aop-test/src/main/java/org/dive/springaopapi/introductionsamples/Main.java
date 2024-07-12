package org.dive.springaopapi.introductionsamples;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class Main {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory(new Dog());
        pf.addAdvice(new RunnableMixin());
//        pf.setProxyTargetClass(true);

        Animal dog = (Animal) pf.getProxy();
        dog.makeSound();
        ((Runnable) dog).run();
    }
}
