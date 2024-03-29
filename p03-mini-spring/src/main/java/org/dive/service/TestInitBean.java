package org.dive.service;

import org.dive.spring.Component;
import org.dive.spring.InitializingBean;

@Component
public class TestInitBean implements InitializingBean {
    private int count;
    @Override
    public void afterPropertiesSet() {
        count = 100;
    }

    public int getCount() {
        return count;
    }
}
