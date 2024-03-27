package org.dive.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = CommonConfig.class)
class ExpTriggerControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void test_1() throws Exception {
        mvc.perform(get("/io-exception"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test_2() throws Exception {
        mvc.perform(get("/arg-exception"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void test_3() throws Exception {
        mvc.perform(get("/rt-exception"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test_4() throws Exception {
        mvc.perform(get("/simple-exception"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}