package org.dive.factorybeantest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class MyServiceFactoryBean implements FactoryBean<MyService> {
    @Override
    public MyService getObject() throws Exception {
        return new MyService(OffsetDateTime.now());
    }

    @Override
    public Class<?> getObjectType() {
        return MyService.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
