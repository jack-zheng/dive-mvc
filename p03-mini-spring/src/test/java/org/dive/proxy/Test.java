package org.dive.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Service proxy = (Service) Proxy.newProxyInstance(
                Test.class.getClassLoader(), new Class[]{Service.class},
                new ServiceHandler(new TestService()));

        proxy.test();
    }
}

interface Service {
    void test();
}
class TestService implements Service {
    @Override
    public void test() {
        System.out.println("invoke test method...");
    }
}

class ServiceHandler implements InvocationHandler {
    private final Object target;

    public ServiceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----- before -----");
        Object result = method.invoke(target, args);
        System.out.println("----- after -----");
        return result;
    }
}
