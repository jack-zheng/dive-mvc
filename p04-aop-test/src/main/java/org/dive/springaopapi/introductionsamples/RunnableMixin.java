package org.dive.springaopapi.introductionsamples;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class RunnableMixin extends DelegatingIntroductionInterceptor implements Runnable {
    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (implementsInterface(mi.getMethod().getDeclaringClass())) {
            return mi.getMethod().invoke(this, mi.getArguments());
        }
        return super.invoke(mi);
    }
}
