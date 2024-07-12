package org.dive.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutBean {
//    @Autowired
    private InnerBean innerBean;

    public InnerBean getInnerBean() {
        return innerBean;
    }
}
