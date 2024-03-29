package org.dive.service;

import org.dive.spring.Component;

@Component
public class TestBPPBean {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
