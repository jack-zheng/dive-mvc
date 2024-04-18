package org.dive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig(AppConfig.class)
class TestControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    void setup(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
    }

    @Test
    public void test() throws Exception {
//        context.getBean(TestController.class).test();
        System.out.println("Is proxy obj:" + AopUtils.isAopProxy(context.getBean(RequestBean.class)));
        System.out.println("Is proxy obj:" + AopUtils.isAopProxy(context.getBean(TestService.class)));
//        mockMvc.perform(get("/test"))
//                .andExpect(status().isOk());
    }
}