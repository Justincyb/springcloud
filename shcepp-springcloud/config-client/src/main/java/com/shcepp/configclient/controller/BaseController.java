package com.shcepp.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ybcheng
 * @Time 2018/5/31 16:56
 * @description
 */
@RestController
@RefreshScope
public class BaseController {

    @Value("${neo.hello}")
    private String hello;
    @Value("${neo.name}")
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
    private DiscoveryClient discoveryClient;
    @Autowired
    private Registration registration;

    @RequestMapping("/registered")
    public String getRegistered(){
        List<ServiceInstance> list =  discoveryClient.getInstances(registration.getServiceId());
        System.out.println("discoveryClient.getServices().size() = " + discoveryClient.getServices().size());
        for( String s :  discoveryClient.getServices()){
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);
            for(ServiceInstance si : serviceInstances){
                System.out.println("    services:" + s + ":getHost()=" + si.getHost());
                System.out.println("    services:" + s + ":getPort()=" + si.getPort());
                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + s + ":getUri()=" + si.getUri());
                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
            }

        }

        System.out.println(list.size());
        if (list != null && list.size() > 0 ) {
            System.out.println( list.get(0).getUri()  );
        }
        return null;
    }

}
