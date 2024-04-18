package org.dive.springaopapi;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class AspectJStylePointCutTest {
    public static void main(String[] args) {
        // Create ProxyFactory
        ProxyFactory proxyFactory = new ProxyFactory(new UserService());
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression("execution(* org.dive.springaopapi.UserService.addUser(..))");
        advisor.setAdvice(new MyBeforeMethodAdvice());

        proxyFactory.addAdvisor(advisor);

        // Get the proxy object
        UserService proxyUserService = (UserService) proxyFactory.getProxy();

        // Call methods on the proxy object
        proxyUserService.addUser("Alice");
        proxyUserService.deleteUser("Bob");
    }
}
