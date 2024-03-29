package org.dive.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new SampleHandler());

        SampleClass proxy = (SampleClass) enhancer.create();
        proxy.test();
    }
}

class SampleClass {
    public void test() {
        System.out.println("Hello World");
    }
}

class SampleHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("------ Before Method Execution ----");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("------ After Method Execution ----");
        return result;
    }
}
