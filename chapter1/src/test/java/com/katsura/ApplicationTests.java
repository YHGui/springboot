package com.katsura;

import com.katsura.service.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Katsura on 2017/2/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void getHello2() throws Exception {
        Assert.assertEquals(blogProperties.getName(), "Katsura");
        Assert.assertEquals(blogProperties.getTitle(), "Spring Boot");
    }
}
