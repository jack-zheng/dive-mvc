package org.dive.spring;

import org.dive.service.Config;
import org.dive.service.NameAwareTestBean;
import org.dive.service.TestBPPBean;
import org.dive.service.TestInitBean;
import org.dive.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class ApplicationContextTest {
    @Test
    public void test_get_singleton_bean() {
        ApplicationContext ctx = new ApplicationContext(Config.class);
        assertSame(ctx.getBean("userService"), ctx.getBean("userService"));
    }

    @Test
    public void test_get_property_bean() {
        ApplicationContext ctx = new ApplicationContext(Config.class);
        Object obj1 = ctx.getBean("prototypeBean");
        Object obj2 = ctx.getBean("prototypeBean");

        assertNotNull(obj1);
        assertNotSame(obj1, obj2);
    }

    @Test
    public void test_autowired() {
        ApplicationContext ctx = new ApplicationContext(Config.class);
        UserService userService = (UserService) ctx.getBean("userService");

        assertNotNull(userService.getUserDao());
        assertSame(userService.getUserDao(), ctx.getBean("userDao"));
    }

    @Test
    public void test_bean_name() {
        ApplicationContext ctx = new ApplicationContext(Config.class);
        NameAwareTestBean bean = (NameAwareTestBean) ctx.getBean("nameAwareTestBean");

        assertEquals(bean.getName(), "nameAwareTestBean");
    }

    @Test
    public void test_InitializingBean() {
        ApplicationContext ctx = new ApplicationContext(Config.class);
        TestInitBean bean = (TestInitBean) ctx.getBean("testInitBean");

        assertEquals(bean.getCount(), 100);
    }

    @Test
    public void test_bpp() {
        ApplicationContext ctx = new ApplicationContext(Config.class);
        TestBPPBean bean = (TestBPPBean) ctx.getBean("testBPPBean");

        assertEquals(bean.getCount(), 100);
    }
}