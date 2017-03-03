package com.katsura.web;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Katsura on 2017/2/21.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }
}
