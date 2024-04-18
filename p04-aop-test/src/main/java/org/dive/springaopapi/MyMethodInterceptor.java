package org.dive.springaopapi;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("--------> Before My Interceptor: " + invocation.getMethod().getName());
        Object result = invocation.proceed();
        System.out.println("--------> After My Interceptor: " + invocation.getMethod().getName());
        return result;
    }
}
