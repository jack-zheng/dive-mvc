package org.dive;

import org.springframework.stereotype.Component;

@Component
public class TargetClass {
    public void doSomething() {
        System.out.println("Doing something");
    }

    public void doSomethingElse() {
        System.out.println("Doing something else");
    }
}
