package com.yeyangshu.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/10/11 9:03
 */

@Service
public class RestService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * defaultFallback 服务降级调用方法
     * @return
     */
    @HystrixCommand(defaultFallback = "back")
    public String alive() {
        String url = "http://user-provider/alive";
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 服务降级调用方法
     * @return
     */
    public String back() {
        return "restTemplate alive 服务降级";
    }
}
