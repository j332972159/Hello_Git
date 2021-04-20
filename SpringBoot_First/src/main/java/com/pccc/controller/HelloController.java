package com.pccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jinquanhua
 * @date 2020/6/4 18:37
 */
@Controller

public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
