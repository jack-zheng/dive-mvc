package org.dive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceB {
    @Autowired
    private ServiceA serviceA;

    public void printService() {
        System.out.println(serviceA);
    }
}
