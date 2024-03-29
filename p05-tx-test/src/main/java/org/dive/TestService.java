package org.dive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestService {
    @Autowired
    private TestService service;
    @Transactional
    public void foo() {
        service.bar();
    }

    @Transactional(propagation = Propagation.NEVER)
    public void bar() {}
}
