package com.yeyangshu.controller;

import com.yeyangshu.api.UserApi;
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

    /**
     * 服务请求时通过 @FeignClient 注解拦截，向 userApi 定义的 url+GetMapping 发送 HTTP 请求，返回结果
     *
     * @return
     */
    @GetMapping("/alive")
    public String alive() {
        return userApi.alive();
    }
}
