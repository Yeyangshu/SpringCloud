package com.yeyangshu.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/14 23:39
 */
@RestController
public class MainController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    EurekaClient eurekaClient;

    @GetMapping("/hi")
    @ResponseBody
    public String getHi() {
        return "hi";
    }

    /**
     * 客户端获取所有的服务
     *
     * @return
     */
    @GetMapping("/client")
    public String client() {
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            System.out.println(service);
        }
        return "hi service";
    }

    /**
     * 客户端获取指定的实例
     *
     * @return
     */
    @GetMapping("/client2")
    public Object client2() {
        return discoveryClient.getInstances("provider");
    }

    /**
     * 客户端获取实例详细信息
     *
     * @return
     */
    @GetMapping("/client3")
    public Object client3() {
        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        for (ServiceInstance ins : instances) {
            System.out.println(ToStringBuilder.reflectionToString(ins));
        }
        return "ServiceInstance information";
    }

    /**
     * Eureka客户端获取并调用服务url
     * @return
     */
    @GetMapping("/client4")
    public Object client4() {

        // 具体服务
        //	List<InstanceInfo> instances = client2.getInstancesById("localhost:provider:80");

        // 使用服务名 ，找列表
        List<InstanceInfo> instances = eurekaClient.getInstancesByVipAddress("provider", false);

        for (InstanceInfo ins : instances) {
            System.out.println(ToStringBuilder.reflectionToString(ins));
        }

        if (instances.size() > 0) {
            // 服务
            InstanceInfo instanceInfo = instances.get(0);
            if (instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
                String url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/hi";
                System.out.println("url:" + url);
                RestTemplate restTemplate = new RestTemplate();
                String respStr = restTemplate.getForObject(url, String.class);
                System.out.println("respStr：" + respStr);
            }
        }
        return "remote invoke url";
    }
}
