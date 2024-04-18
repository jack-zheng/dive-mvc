package org.dive.proxy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

public class InnerBean {
    private final Date date;

    public InnerBean(Date date) {
        this.date = date;
    }

    public void test() {
        System.out.println("InnerBean.test " + date);
    }
}
