package org.dive;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodAspect {
    @Before("execution(* org.dive.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("---------- JoinPoint: " + joinPoint.getSignature());
        System.out.println("---------- before ----------");
    }

//    @Around("execution(* org.dive.*.*(..))")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("---------- around start ----------");
//        System.out.println("---------- JoinPoint: " + joinPoint.getSignature());
//        Object result = joinPoint.proceed();
//        System.out.println("---------- around end ----------");
//        return result;
//    }
}
