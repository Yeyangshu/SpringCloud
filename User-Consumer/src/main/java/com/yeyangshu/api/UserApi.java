package com.yeyangshu.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 不结合 eureka，就是自定义一个client名字。用 url 属性指定服务器列表，url="http://ip:port"
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/22 23:46
 */
@FeignClient(name = "name", url = "http://localhost:8001")
public interface UserApi {
    @GetMapping("/alive")
    public String alive();
}
