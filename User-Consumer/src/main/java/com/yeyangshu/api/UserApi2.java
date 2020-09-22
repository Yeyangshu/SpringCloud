package com.yeyangshu.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 结合 eureka，使用服务名
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/22 23:46
 */
@FeignClient(name = "user-provider")
public interface UserApi2 {
    @GetMapping("/alive")
    public String alive();
}
