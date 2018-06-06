package com.shcepp.orderserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Justin
 * @Time 2018/6/4 15:40
 * @Description
 */
@RestController
@RefreshScope
public class BaseController {

    @Value("${hello}")
    private String hello;
    @Value("${name}")
    private String name;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }

    @RequestMapping("/name")
    public String getName(){
        return this.name;
    }

}
