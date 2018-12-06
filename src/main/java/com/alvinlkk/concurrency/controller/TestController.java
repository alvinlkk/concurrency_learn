package com.alvinlkk.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author alvinkk
 * @create 2018-12-06 20:09
 **/
@Controller
@Slf4j
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "hello";
    }
}
