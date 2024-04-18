package org.dive.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("----------- SingletonBean.destroy -----------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----------- SingletonBean.afterPropertiesSet -----------");
    }
}
