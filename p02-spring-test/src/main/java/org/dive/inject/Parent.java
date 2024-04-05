package org.dive.inject;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class Parent {
    @Autowired
    private TestService testService;

    public void printParentService() {
        System.out.println("parent class: " + this);
        System.out.println("parent service: " + this.testService);
    }
}
