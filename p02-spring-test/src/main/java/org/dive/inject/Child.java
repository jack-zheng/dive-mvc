package org.dive.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Child extends Parent {

    @Autowired
    private TestService testService;

    public void printService() {
        System.out.println("child class: " + this);
        System.out.println("child service: " + this.testService);
    }
}
