package org.dive;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestBean {
    public void test() {
        System.out.println("RequestBean.test");
    }
}
