package org.dive.service;

import org.dive.spring.BeanNameAware;
import org.dive.spring.Component;

@Component
public class NameAwareTestBean implements BeanNameAware {
    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
