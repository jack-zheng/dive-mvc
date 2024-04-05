package org.dive.inject;

import org.springframework.stereotype.Component;

@Component
public class AnotherService {
    public void test() {
        System.out.println("AnotherService");
    }
}
