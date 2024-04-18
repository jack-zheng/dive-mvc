package org.dive.springaopapi;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Main {
    public static void main(String[] args) {
        // Create ProxyFactory
        ProxyFactory proxyFactory = new ProxyFactory(new UserService());
//        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new MyBeforeMethodAdvice()));
        proxyFactory.addAdvice(new MyBeforeMethodAdvice());
        proxyFactory.addAdvice(new MyMethodInterceptor());

        // Get the proxy object
        UserService proxyUserService = (UserService) proxyFactory.getProxy();

        // Call methods on the proxy object
        proxyUserService.addUser("Alice");
//        proxyUserService.deleteUser("Bob");
    }
}
