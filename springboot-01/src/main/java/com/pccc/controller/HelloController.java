package com.pccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jinquanhua
 * @date 2020/6/4 20:04
 */
/*@Controller
@ResponseBody*/
@RestController
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/haha")
    public String getHello(){
        logger.info("开始....");
        return "haha";
    }
}
