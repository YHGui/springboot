package com.katsura;

import com.katsura.web.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter1ApplicationTests {

    private MockMvc mvc;
    //MockMvc对系统的Controller进行单元测试，SpringMvc的测试往往看似比较复杂，因为其需要一个ServletContext
    //模拟请求和响应
    //原本注解包括
    //@webappconfiguration为一级注释，用于声明一个ApplicationContext集成测试加载WebApplicationContext。
    // 作用是模拟ServletContext，现如今只有@SpringBootTest一个注解全部搞定
    //测试要满足事物回滚，
    // 为什么要事物回滚？
    // 1、测试过程对数据库的操作，会产生脏数据，影响我们数据的正确性
    //2、不方便循环测试，即假如这次我们将一个记录删除了，下次就无法再进行这个Junit测试了，因为该记录已经删除，将会报错
    //3、如果不使用事务回滚，我们需要在代码中显式的对我们的增删改数据库操作进行恢复，将多很多和测试无关的代码
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello, World!")));
    }
}
