package org.dive.inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TestService {
    public void test() {
        System.out.println("TestService");
    }
}
