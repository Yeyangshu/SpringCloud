package com.yeyangshu.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 负载均衡测试 controller
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/15 22:32
 */
@RestController
public class RibbonLoadBalancerController {
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    /**
     * provider 负载均衡
     *
     * 默认：ZoneAvoidanceRule（区域权衡策略）：复合判断Server所在区域的性能和Server的可用性，轮询选择服务器。
     * @return
     */
    @GetMapping("/client6")
    public Object client6() {
        ServiceInstance instance = loadBalancerClient.choose("provider");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/hi";
        System.out.println(instance.getHost() + instance.getPort());
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 自定义负载均衡算法
     * @return
     */
    @GetMapping("/client7")
    public Object client7() {
        List<ServiceInstance> instances = discoveryClient.getInstances("provider");

        /* 自定义算法 */
        // 例：随机算法
        int nextInt = new Random().nextInt(instances.size());
        AtomicInteger atomicInteger = new AtomicInteger();

        ServiceInstance instance = instances.get(nextInt);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/hi";
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 自动处理 url
     * 在restTemplate添加 @LoadBalanced 注解
     * @return
     */
    @GetMapping("/client9")
    public Object client9() {
        // 自动处理URL
        String url ="http://provider/hi";
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println(respStr);
        return respStr;
    }
}
