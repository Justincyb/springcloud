package com.shcepp.memberserver.controller.model;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Justin
 * @Time 2018/6/5 16:43
 * @Description
 */
public class CeppService {

    // 服务编号
    private String serNo;
    // 服务名称
    private String serName;
    // 服务状态
    private List<ServiceInstance> serInfo;

    public String getSerNo() {
        return serNo;
    }

    public void setSerNo(String serNo) {
        this.serNo = serNo;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public List<ServiceInstance> getSerInfo() {
        return serInfo;
    }

    public void setSerInfo(List<ServiceInstance> serInfo) {
        this.serInfo = serInfo;
    }
}
