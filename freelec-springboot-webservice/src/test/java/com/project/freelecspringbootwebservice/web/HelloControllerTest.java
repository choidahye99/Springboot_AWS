package com.project.freelecspringbootwebservice.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class) //JUnit4에서는 @RunWith 사용
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello() throws Exception{
        String hello = "hello";

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/hello");
        mvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().string(hello));

    }

    @Test
    public void helloDto() throws Exception{
        String name = "hello";
        int amount = 1000;

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/hello/dto").param("name", name).param("amount", String.valueOf(amount));
        mvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));


    }

}
