package com.katsura.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Katsura on 2017/2/17.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(){
        return "Hello, World!";
    }
}
