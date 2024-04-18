package org.dive.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("----------- PrototypeBean.destroy -----------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----------- PrototypeBean.afterPropertiesSet -----------");
    }
}
