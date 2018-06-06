package com.shcepp.memberserver.controller;

import com.shcepp.memberserver.controller.model.CeppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ybcheng
 * @Time 2018/5/31 16:56
 * @description
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
    public String getName() {
        return this.name;
    }

    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * @Author: Justin
     * @Date: 2018/6/5 16:59
     * @Description:  查询eureka注册中心每个服务的具体状态，返回服务的具体信息
     */
    @RequestMapping("serList")
    public List getEurakeServerList(){
        // 服务列表
        List<String> serverList = discoveryClient.getServices();
        ArrayList serList = new ArrayList<>();
        int i = 1;
        for (String service:
        serverList) {
            CeppService ceppService = new CeppService();
            ceppService.setSerNo("服务编号："+i);
            ceppService.setSerName(service);
            // 状态
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(service);
            ceppService.setSerInfo(serviceInstances);
            i++;
            serList.add(ceppService);
        }
        return serList;
    }
}
