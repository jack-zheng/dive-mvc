package org.dive.service;

import org.dive.spring.BeanPostProcessor;
import org.dive.spring.Component;

@Component
public class BPPBean implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (beanName.equals("testBPPBean")) {
            TestBPPBean testBPPBean = (TestBPPBean) bean;
            testBPPBean.setCount(100);
            System.out.println("testBPPBean count set...");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (beanName.equals("testBPPBean")) {
            System.out.println("bpp::after: " + beanName);
        }
        return bean;
    }
}
