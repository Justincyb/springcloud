package com.shcepp.configclient.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Author ybcheng
 * @Time 2018/6/1 11:19
 * @description
 */
@Component("health1")
public class HealthInfo implements HealthIndicator{

    private static final String VERSION = "v1.0.0";

    @Override
    public Health health() {

        int code = check();



        if (code != 0) {
            Health.down().withDetail("code", code).withDetail("version", VERSION).build();
        }
        return Health.up().withDetail("code", code)
                .withDetail("version", VERSION).up().build();
    }
    private int check() {
        return 0;
    }
}
