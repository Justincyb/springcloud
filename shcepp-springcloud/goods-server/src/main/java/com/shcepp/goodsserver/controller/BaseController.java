package com.shcepp.goodsserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Justin
 * @Time 2018/6/5 12:59
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
    public String getConfig() {
        return this.hello;
    }
}
