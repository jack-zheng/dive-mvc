package org.dive.springaopapi;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;

public class LoggingAdvisor implements Advisor {

    @Override
    public Advice getAdvice() {
        return null;
    }

    @Override
    public boolean isPerInstance() {
        return Advisor.super.isPerInstance();
    }
}