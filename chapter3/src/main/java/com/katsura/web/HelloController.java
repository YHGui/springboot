package com.katsura.web;

import com.katsura.Exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Katsura on 2017/2/18.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() throws Exception {
        throw new Exception("error occur");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("error2 occur");
    }
}
