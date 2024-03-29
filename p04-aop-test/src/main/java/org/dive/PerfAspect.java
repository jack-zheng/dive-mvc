package org.dive;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerfAspect {
    // write advice to monitor doSomething method
    @Around("execution(* org.dive.TargetClass.doSomething())")
    private void monitorDoSomething(ProceedingJoinPoint jp) {
        System.out.println("---- before ----");
        try {
            jp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("---- after ----");
    }

    @DeclareParents(value = "org.dive.TargetClass", defaultImpl = DefaultTimer.class)
    private Timer timer;
}
