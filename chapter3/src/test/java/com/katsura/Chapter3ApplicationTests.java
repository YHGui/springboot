package com.katsura;

import com.katsura.web.HelloController;
import com.katsura.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//mvn clean package 编译的时候会进行测试

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter3ApplicationTests {

    private MockMvc mvc;


    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(
                new HelloController(),
                new UserController()).build();
    }

//    @Test
//    public void getHello() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Hello, World!")));
//    }

    @Test
    public void testUserController() throws Exception {

        RequestBuilder request = null;

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));


        request = post("/users/")
                .param("id", "1")
                .param("name", "test master")
                .param("age", "20");
        mvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(equalTo("success")));

        request = get("/users/1");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"test master\",\"age\":20}")));
        //测试的json数据属性之间不能出现空格

        request = put("/users/1")
                .param("name", "top test master")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        request = get("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"top test master\",\"age\":30}")));

        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

}
