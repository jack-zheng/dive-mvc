package org.dive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User implements InitializingBean, DisposableBean {
    private int id;
    private String name;

    @Override
    public void destroy() throws Exception {
        System.out.printf("------- User[%d].destroy -------%n", id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.printf("------- User[%d].afterPropertiesSet -------%n", id);
    }
}
