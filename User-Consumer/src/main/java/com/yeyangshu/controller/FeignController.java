package com.yeyangshu.controller;

import com.yeyangshu.api.UserApi;
import com.yeyangshu.api.UserApi2;
import com.yeyangshu.api.UserApi3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/22 23:45
 */
@RestController
public class FeignController {
    @Autowired
    UserApi userApi;

//    @Autowired
//    UserApi2 userApi2;

//    @Autowired
//    UserApi3 userApi3;

    /**
     * 不结合 eureka
     * 服务请求时通过 @FeignClient 注解拦截，向 userApi 定义的 url+GetMapping 发送 HTTP 请求，返回结果
     *
     * @return
     */
//    @GetMapping("/alive")
//    public String alive() {
//        return userApi.alive();
//    }

    /**
     * 结合 eureka
     * 和 RestTemplate 有区别吗？
     * 好处：
     *  - 没有代码侵入
     *  - 方便做异构系统
     *
     * @return
     */
//    @GetMapping("/alive2")
//    public String alive2() {
//        return userApi2.alive();
//    }

    /**
     * 自定义接口，Feign 调用服务提供者
     * @return
     */
//    @GetMapping("/alive3")
//    public String alive3() {
//        return userApi3.isAlive();
//    }
}
