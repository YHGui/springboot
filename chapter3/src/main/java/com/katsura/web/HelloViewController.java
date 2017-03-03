package com.katsura.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by Katsura on 2017/2/18.
 */
@Controller
@ApiIgnore
public class HelloViewController {

    @RequestMapping("/")
    public String indexView(ModelMap map){
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

    @RequestMapping("/index2")
    public String indexFreemarker(ModelMap map){
        map.addAttribute("host", "http://blog.didispace.com");
        return "index2";
    }
}
